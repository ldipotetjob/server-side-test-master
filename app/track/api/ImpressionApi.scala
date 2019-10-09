package track.api

import javax.inject._

import play.api.Logging
import play.api.libs.json._
import play.api.mvc._
import track.domain.{Impression, ImpressionIn}
import track._

import scala.concurrent.ExecutionContext
import track.ImplicitConversions._



@Singleton
class ImpressionApi @Inject()(cc: ControllerComponents, daorepository:ImpressionRepositoryTrait)(implicit exec: ExecutionContext) extends AbstractController(cc) with Logging {

  val calculator = new ChargeCalculator

  // Purposefully made these methods sparse. Candidate is supposed to fill in the required code
  // Uncomment the endpoints in routes.conf when you have done implementing these methods

  def save = Action.async { implicit request =>
    val newImpression: ImpressionIn = request.body.asJson.get.as[ImpressionIn]
   // val impressionToInsert:Impression = Impression(None,newImpression.`placement-id`,newImpression.bidder,None)
    daorepository.save(newImpression).map(id => Ok(Json.obj( "impression-id" -> (s"$id"))))
 }

  def get(impressionId:Int) = Action.async { implicit request =>

    daorepository.findById(impressionId).map {
      _ match {
        case Some(result) => Ok(Json.toJson(result) ).withHeaders(CONTENT_TYPE->JSON)
        case None => NotFound(Json.obj("status" ->"failed", "message" -> s"Couldn't find impression $impressionId"))
      }
    }
  }

  //could be a better way for count the record but I don't know quite well SLICK, I guess that they have
  //a better filter solution
  def count(bidder:String, strdate:String) =  Action.async { implicit request =>

    daorepository.countByBidderAndDate(bidder, strdate).map {
      _ match {
        case result if result > 0 => Ok(Json.obj("status" -> "OK", "message" -> Json.toJson(result))).
          withHeaders(CONTENT_TYPE -> JSON)
        case _ => NotFound(Json.obj
        ("status" -> "failed", "message" -> s"Couldn't find impressions for that bidder $bidder for day $strdate"))
      }
    }
  }

  def getCharges = Action.async { implicit request =>
    daorepository.all.map(impressions=>Ok(Json.toJson(
      impressions.map{impression=>
          ChargeResult(impression.id.get,impression.timestamp.get,calculator.totalCharges(TimeRate(impression.timestamp.get)).rate)
      }
     )).withHeaders(CONTENT_TYPE->JSON))
    }
}
