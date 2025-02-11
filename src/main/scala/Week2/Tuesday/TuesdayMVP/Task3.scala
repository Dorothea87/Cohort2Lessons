package Week2.Tuesday.TuesdayMVP

object Task3 extends App {


  //After reviewing all combinations, which ones are true when compared using the “==“
  //operator? Once decided, code it and check!
  //a) case class Muffin(flavour: String, price: Double, storeBoughtFrom: String)
  //b) val chocolateMuffin = Muffin("chocolate", 3.50, "Mercator Bakery")
  //c) val blueberryMuffin = Muffin("blueberry", 3.50, "Mercator Bakery")
  //d) val vanillaMuffin = Muffin("vanilla", 3.50, "Mercator Bakery")
  //e) val anotherChocolateMuffin = Muffin("chocolate", 3.50, "Mercator Bakery")
  //f) val oneMoreChocolateMuffin = Muffin(”Chocolate", 3.50, "Mercator Bakery")
  //g) val finalChocolateMuffin = Muffin("choocolate", 2.50, "MercatorBakery")

  //=> b) == e)
  //=> all other combinations are false

  case class Muffin(flavour: String, price: Double, storeBoughtFrom: String)
  val chocolateMuffin = Muffin("chocolate", 3.50, "Mercator Bakery")
  val anotherChocolateMuffin = Muffin("chocolate", 3.50, "Mercator Bakery")
  println(chocolateMuffin == anotherChocolateMuffin)
}
