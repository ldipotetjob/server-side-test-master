package track

import javax.inject.{Inject, Singleton}

import play.api.Logging
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import java.sql._

import java.time.LocalDateTime



import track.domain.{Impression, ImpressionIn}

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class ImpressionRepository @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)
                                     (implicit ec: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] with Logging with ImpressionRepositoryTrait{

  // Create your database binding and corresponding methods here
  import profile.api._

class Impressions(tag: Tag) extends Table[Impression](tag, "IMPRESSION") {
  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
  def bidder = column[String]("BIDDER")
  def `placement-id` = column[String]("PLACEMENT")
  def timestamp = column[LocalDateTime]("TIMEVAL", O.Default(LocalDateTime.now()))
  def * = (id.?, `placement-id`,bidder,timestamp.?) <> (Impression.tupled, Impression.unapply _)
}
  private val impressions = TableQuery[Impressions]

  def findById(id: Int): Future[Option[Impression]] =
    db.run(impressions.filter(_.id === id).result.headOption)

  def countByBidderAndDate(bidderIn: String, date:String): Future[Int] ={

    implicit val localDateTimeColumnType: BaseColumnType[LocalDateTime] = MappedColumnType.base[LocalDateTime, Timestamp](Timestamp.valueOf, _.toLocalDateTime)

    db.run(impressions.filter(_.bidder === bidderIn).
      map(_.timestamp).filter(d => d === LocalDateTime.parse(date)).size.result)
  }

  def all(): Future[Seq[Impression]] = db.run(impressions.result)

  def save(impression: ImpressionIn): Future[Int] = {
    val impressionToInsert:Impression = Impression(None,impression.`placement-id`,impression.bidder,Option(LocalDateTime.now()))
    db.run(impressions returning impressions.map(_.id) += impressionToInsert)
  }

}

