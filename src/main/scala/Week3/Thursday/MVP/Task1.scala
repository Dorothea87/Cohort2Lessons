package Week3.Thursday.MVP

//1) When given an input of a string, name of a country, you need to return a string of that country’s capital city, for example “France” should return “Paris”, “England” should return "London” etc.
//You must:
//- Use pattern matching.
//- Think about how you will deal with countries you have not included.
//- Think about what happens when someone has entered a country in all lowercase/ uppercase or mixed?
//- Think about how you account for unneeded white spaces entered (e.g. " England ")?

object Task1 extends App{

  val capitalCity: String = "    Germany    "

  capitalCity.toLowerCase.trim() match {
    case "france" => println("Paris")
    case "germany" => println("Berlin")
    case "new zealand" => println("Wellington")
    case "austria" => println("Vienna")
    case "spain" => println("Madrid")
    case "ireland" => println("Dublin")
    case _ => println("Invalid entry, country not in list")
  }
}
