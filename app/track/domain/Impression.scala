package track.domain

import java.time.LocalDateTime

case class Impression(id:Option[Int]=None,`placement-id`: String,bidder:String, timestamp:Option[LocalDateTime]=None)

case class ImpressionIn(`placement-id`: String, bidder:String)
