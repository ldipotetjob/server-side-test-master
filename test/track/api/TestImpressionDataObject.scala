package track.api

import java.time.LocalDateTime

import track.domain.{Impression, ImpressionIn}

object TestImpressionDataObject {

  /** Data For Testing Charge Calculator */

  val dateTimeSaturday = LocalDateTime.parse("2019-09-28T11:50")
  val dateTimeMorningWeekday = LocalDateTime.parse("2019-09-26T07:50")
  val dateTimeEveningWeekEnd = LocalDateTime.parse("2019-09-28T20:50")
  val dateTimeEveningWeekday = LocalDateTime.parse("2019-09-12T18:30")
  val dateTimeDefaultWeekday = LocalDateTime.parse("2019-09-12T13:30")

  /** Data For Testing Impression api */

  val impression = Impression(Option(1),"ABC123","Appnexus",Option(dateTimeEveningWeekEnd))
  val impression1 = Impression(Option(2),"ABC123","Appnexus",Option(dateTimeEveningWeekday))
  val impression2 = Impression(Option(3),"ABC123","Appnexus",Option(dateTimeDefaultWeekday))
  val impressionIn = ImpressionIn("ABC123","Appnexus")
}
