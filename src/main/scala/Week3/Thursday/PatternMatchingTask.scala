package Week3.Thursday

object PatternMatchingTask extends App {

  //TASK 1
  val pizzaFlavour: String = "sweet"
  pizzaFlavour.toLowerCase match {
    case "sweet" => println("Get a pizza Hawaii, with some delicious pineapple.")
    case "smoky" => println("Treat yourself to a barbecue feast.")
    case "salty" => println("How about a classic pepperoni pizza?")
    case x => println(s"So sorry, I don't have a suggestion for $x")
  }

  //TASK 2a)
  val pizzaMeasurements: String = "Small"
  pizzaMeasurements match {
    case "Personal" => println(7)
    case "Small" => println(9)
    case "Medium" => println(11)
    case "Large" => println(14)
    case _ => println("Enter a valid size")
  }

  case class Pizza(size: Int, crust: String)
  val pizzaOrder: Pizza = Pizza(11, "stuffed")
  val getPrice = pizzaOrder match {
    case Pizza(7, "classic") => 5.99
    case Pizza(9, "classic") => 10.99
    case Pizza(9, "italian") => 10.99
    case Pizza(11, "classic") => 12.99
    case Pizza(11, "italian") => 12.99
    case Pizza(11, "stuffed") => 15.98
    case Pizza(14, "classic") => 14.99
    case Pizza(14, "italian") => 14.99
    case Pizza(14, "stuffed") => 17.98
    case _ => "Enter a valid pizza"
  }
  println(getPrice)
}
