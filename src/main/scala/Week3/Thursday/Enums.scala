package Week3.Thursday

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

  //Pattern matching example

  def matchingWithEnum(weekdays: BetterWeekday.Value) = {
    weekdays match {
//      case BetterWeekday.Monday => println(s"Oh, it's ${BetterWeekday.Monday}.")
      case BetterWeekday.Tuesday => println(s"Oh, it's ${BetterWeekday.Tuesday}.")
      case BetterWeekday.Wednesday => println(s"Oh, it's ${BetterWeekday.Wednesday}.")
      case BetterWeekday.Thursday => println(s"Oh, it's ${BetterWeekday.Thursday}.")
      case BetterWeekday.Friday => println(s"Oh, it's ${BetterWeekday.Friday}.")
      case BetterWeekday.Saturday => println(s"Oh, it's ${BetterWeekday.Saturday}.")
      case BetterWeekday.Sunday => println(s"Oh, it's ${BetterWeekday.Sunday}.")
    }
  }

  matchingWithEnum(BetterWeekday.Saturday)

  //We want an exhaustive match - all enums are assigned to a match case
  //we don't see an error or warning if it isn't

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
  abstract class Error(name: String, errorCode: Int)

  case object NotFound extends Error("Not found", 404)

  case object HairColourError extends Error("Hair colour is invalid", 404)
}
