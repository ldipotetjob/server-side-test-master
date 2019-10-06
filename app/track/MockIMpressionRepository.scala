package track
import java.time.LocalDateTime

import track.domain.Impression

import scala.concurrent.Future

class MockIMpressionRepository extends ImpressionRepositoryTrait{

val impression = Impression(Option(1),"ABC123","Appnexus",Option(dateTimeEveningWeekEnd))
val impression1 = Impression(Option(2),"ABC123","Appnexus",Option(dateTimeEveningWeekday))
val impression2 = Impression(Option(3),"ABC123","Appnexus",Option(dateTimeDefaultWeekday))

  val dateTimeEveningWeekEnd = LocalDateTime.parse("2019-09-28T20:50")
  val dateTimeEveningWeekday = LocalDateTime.parse("2019-09-12T18:30")
  val dateTimeDefaultWeekday = LocalDateTime.parse("2019-09-12T13:30")

def findById(id: Int): Future[Option[Impression]] = Future.
  successful(Option(Impression(Option(id),"ABC123","Appnexus",Option(dateTimeEveningWeekEnd))))

def countByBidderAndDate(bidderIn: String, date: String): Future[Int] = Future.successful(3)

def all() : Future[Seq[Impression]] = Future.successful(Seq(impression,impression1,impression2))

def save(impression: Impression) : Future[Int] = Future.successful(3)

}
