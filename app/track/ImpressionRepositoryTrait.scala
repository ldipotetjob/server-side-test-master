package track


import track.domain.{Impression, ImpressionIn}

import scala.concurrent.Future

trait ImpressionRepositoryTrait {

  def findById(id: Int): Future[Option[Impression]]
  def countByBidderAndDate(bidderIn: String, date:String): Future[Int]
  def all(): Future[Seq[Impression]]
  def save(impression: ImpressionIn): Future[Int]


}
