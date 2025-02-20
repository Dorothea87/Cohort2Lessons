package Week3

import Week3.Enums.Weekday.Value

object Enums extends App {

  //Finite sets of data

  //Extends enumeration
  object Weekday extends Enumeration {
    val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
  }
  println(Weekday.values)
  println(Weekday.Saturday)

  //Below is useful with acronyms
  object BetterWeekday extends Enumeration {
    val Monday = Value("Mon")
    val Tuesday = Value("Tue")
    val Wednesday = Value("Wed")
    val Thursday = Value("Thur")
    val Friday = Value("Fri")
    val Saturday = Value("Sat")
    val Sunday = Value("Sun")
  }
  println(BetterWeekday.values)
  println(BetterWeekday.Sunday)

  object ReorderedWeekday extends Enumeration {
    val Monday = Value(1)
    val Tuesday = Value(2)
    val Wednesday = Value(3)
    val Thursday = Value(4)
    val Friday = Value(5)
    val Saturday = Value(6)
    val Sunday = Value(0)
  }
  println(ReorderedWeekday.values)

  //sealed case object --> preferred way
  sealed trait Weekday
  case object Monday extends Weekday
  case object Tuesday extends Weekday
  case object Wednesday extends Weekday
  case object Thursday extends Weekday
  case object Friday extends Weekday
  case object Saturday extends Weekday
  case object Sunday extends Weekday


  //Custom errors
  abstract class Error (name: String, errorCode: Int)
  case object NotFound extends Error("Not found", 404)
  case object HairColourError extends Error("Hair colour is invalid", 404)
}
