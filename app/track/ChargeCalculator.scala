package track

import java.time.{LocalDateTime, LocalTime}

class ChargeCalculator {

  val timeHour9am = LocalTime.parse("09:01")
  val timeHour9pm = LocalTime.parse("21:01")
  val timeHour6pm = LocalTime.parse("17:59")

  val morningCharge: PartialFunction[TimeRate, TimeRate] = {
    case time if (time.dateTime.getHour > 6) && (time.dateTime.toLocalTime.compareTo(timeHour9am) < 0) =>
      time.copy(rate = 0.11 + weekendCharge(time).rate)
  }

  val eveningCharge: PartialFunction[TimeRate, TimeRate] = {
    case time if (time.dateTime.toLocalTime.compareTo(timeHour6pm) > 0) && (time.dateTime.toLocalTime.compareTo(timeHour9pm) < 0) =>
      time.copy(rate = 0.12 + weekendCharge(time).rate)
  }

  val defaultCharge: PartialFunction[TimeRate, TimeRate] = {
    case time => time.copy(rate = 0.10 + weekendCharge(time).rate)
  }

  val weekendCharge: PartialFunction[TimeRate, TimeRate] =  {
    case time if (time.dateTime.getDayOfWeek.getValue>5) => time.copy(rate = 0.04)
    case time @ _ => time.copy(rate = 0.0)
  }
  // Calculate the total charge here
  val totalCharges: PartialFunction[TimeRate, TimeRate] = morningCharge orElse eveningCharge orElse defaultCharge
}

case class TimeRate(dateTime: LocalDateTime, rate:Double = 0.0 )
