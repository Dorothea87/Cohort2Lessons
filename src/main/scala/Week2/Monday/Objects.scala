package Week2.Monday

object Objects extends App {

  object PrimaryColours { //grouping!
    val blue: String = "blue"
    val red: String = "red"
    val yellow: String = "yellow"
  }

  //calling the objects
  println(PrimaryColours.red)
  println(PrimaryColours.red.toUpperCase())

  object DaysOfTheWeek {
    val mon: String = "Monday"
    val tue: String = "Tuesday"
    val wed: String = "Wednesday"
    val thur: String = "Thursday"
    val fri: String = "Friday"
    val sat: String = "Saturday"
    val sun: String = "Sunday"
  }

  //calling the object
  println(DaysOfTheWeek.sat)
  println(DaysOfTheWeek.wed)
}
