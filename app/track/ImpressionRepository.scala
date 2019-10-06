package track

import javax.inject.{Inject, Singleton}

import play.api.Logging
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import java.time.{LocalDate, LocalDateTime, ZoneId}

import track.domain.Impression

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
  def timestamp = column[LocalDateTime]("TIMEVAL")
  def * = (id.?, `placement-id`,bidder,timestamp.?) <> (Impression.tupled, Impression.unapply _)
}

  private val impressions = TableQuery[Impressions]

  def findById(id: Int): Future[Option[Impression]] =
    db.run(impressions.filter(_.id === id).result.headOption)

  def countByBidderAndDate(bidderIn: String, date:String): Future[Int] =
    db.run(impressions.filter(_.bidder===bidderIn ).size.result)

  def all(): Future[Seq[Impression]] = db.run(impressions.result)

  def save(impression: Impression): Future[Int] = {
    db.run(impressions returning impressions.map(_.id) += impression)
  }

}

