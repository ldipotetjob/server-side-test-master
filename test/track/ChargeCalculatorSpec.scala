package track

import org.scalatest.{FlatSpec, Matchers}
import track.api.TestImpressionDataObject.
{dateTimeSaturday,
dateTimeMorningWeekday,
dateTimeEveningWeekEnd,
dateTimeEveningWeekday,
dateTimeDefaultWeekday}

class ChargeCalculatorSpec extends FlatSpec with Matchers {

  val chargecalculator = new ChargeCalculator


   /** materializer is needed for call an action with an specific request */

  "A ChargeCalculator" should "calculate on weekday" in {
    assert(chargecalculator.totalCharges(TimeRate(dateTimeMorningWeekday)).rate === (0.11))
  }

  "A ChargeCalculator" should "calculate on evenningweekend" in {
    assert(chargecalculator.totalCharges(TimeRate(dateTimeEveningWeekEnd)).rate === (0.16))
  }

  "A ChargeCalculator" should "calculate on weekend" in {
    assert(chargecalculator.totalCharges(TimeRate(dateTimeSaturday)).rate === (0.14))
   }

  "A ChargeCalculator" should "calculate on evening weekday" in {
    assert(chargecalculator.totalCharges(TimeRate(dateTimeEveningWeekday)).rate === (0.12))
  }
  "A ChargeCalculator" should "calculate on default weekday" in {
    assert(chargecalculator.totalCharges(TimeRate(dateTimeDefaultWeekday)).rate === (0.10))
  }

}