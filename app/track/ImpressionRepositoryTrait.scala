package track


import track.domain.Impression

import scala.concurrent.Future

trait ImpressionRepositoryTrait {

  def findById(id: Int): Future[Option[Impression]]
  def countByBidderAndDate(bidderIn: String, date:String): Future[Int]
  def all(): Future[Seq[Impression]]
  def save(impression: Impression): Future[Int]


}
