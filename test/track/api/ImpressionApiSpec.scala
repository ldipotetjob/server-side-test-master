package track.api

import org.mockito.Mockito.when
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FlatSpec, Matchers}
import play.api.libs.json.Json
import play.api.mvc.ControllerComponents
import play.api.test.FakeRequest
import play.api.test.Helpers._
import play.api.test._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import track.{ChargeResult, ImpressionRepositoryTrait}
import track.api.TestImpressionDataObject._
import track.domain.Impression
import track.ImplicitConversions._

import scala.io.Source


//We should test here Controller and Actions

class ImpressionApiSpec extends FlatSpec with Matchers with MockitoSugar {

  val mockControllerComponents = mock[ControllerComponents]
  val mockImpressionRepository = mock[ImpressionRepositoryTrait]
  val seqImpression = Seq(impression,impression1,impression2)
  val rightImpressionJson = Source.fromURL(getClass.getResource("/rightimpression.json")).getLines.mkString

  when(
    mockImpressionRepository.findById(1)
  ) thenReturn Future.successful(Option(impression))

  when(
    mockImpressionRepository.findById(20)
  ) thenReturn Future.successful(None)

  when(
    mockImpressionRepository.all()
  ) thenReturn Future.successful(seqImpression)

  when(
    mockImpressionRepository.save(impressionIn1)
  ) thenReturn Future.successful(1)


  val testImpressionApiController = new ImpressionApi(Helpers.stubControllerComponents(), mockImpressionRepository)

  "Request GET  /impression/1 " should
    "return a json file Response with a 200 status code" in {
    val result = testImpressionApiController.get(1).apply(FakeRequest(GET, "/"))
    val resultImpression: Impression = (contentAsJson(result)).as[Impression]
    resultImpression.id should equal (impression.id)
    resultImpression.bidder should equal (impression.bidder)
    resultImpression.`placement-id` should equal (impression.`placement-id`)
    status(result) shouldBe OK
  }

  "Request GET  /impression/20 " should
    "return a json file Response with a NotFound status code and failed status" in {
    val result = testImpressionApiController.get(20).apply(FakeRequest(GET, "/"))
    //val resultImpression: Impression = (contentAsJson(result)).as[Impression]
    status(result) shouldBe NOT_FOUND
    (contentAsJson(result) \ "status" ).as[String] should equal("failed")
    (contentAsJson(result) \ "message" ).as[String] should equal("Couldn't find impression 20")
  }

  "Request GET  /charges " should
    "return a json file Response with the charges a 200 status code" in {
    val result = testImpressionApiController.getCharges.apply(FakeRequest(GET, "/"))
    //val resultImpression: Impression = (contentAsJson(result)).as[Impression]
    status(result) shouldBe OK
    val resultImpression: Seq[ChargeResult] = (contentAsJson(result)).as[Seq[ChargeResult]]
    resultImpression.size should equal(3)
    }
  "Request POST  /json file " should
    "return a json file Response with the charges a 200 status code" in {
    //val result = testImpressionApiController.getCharges.apply(FakeRequest(POST, "/").withJsonBody(rightImpressionJson))

    val result = testImpressionApiController.save.apply(FakeRequest(POST, "/")
      .withJsonBody(Json.toJson(impressionIn)))
    status(result) shouldBe OK
    val resultSaveImpression: String = (contentAsJson(result) \ "impression-id").as[String]
    resultSaveImpression should equal("1")
  }
}
