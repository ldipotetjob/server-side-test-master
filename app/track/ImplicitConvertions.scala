package track

import java.time.LocalDateTime

import play.api.libs.json.{Format, Json}
import track.domain.{Impression, ImpressionIn}

object ImplicitConversions {
  implicit val impressionInFormat: Format[ImpressionIn] = Json.format[ImpressionIn]
  implicit val impressionFormat: Format[Impression] = Json.format[Impression]
  implicit val chargeResultFormat: Format[ChargeResult] = Json.format[ChargeResult]
}
case class ChargeResult(id:Int, timestamp:LocalDateTime, rate:Double)