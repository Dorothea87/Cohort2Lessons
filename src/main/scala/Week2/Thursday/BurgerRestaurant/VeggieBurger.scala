package Week2.Thursday.BurgerRestaurant


class VeggieBurger(doublePatty: Boolean, typeOfBun: Burger.BunType) extends Burger(doublePatty, typeOfBun) with Sauces {

}

object BurgerLogic extends App {
  val veggieBurger1 = new VeggieBurger(true, Burger.GlutenFree) with Ketchup with Mayo {
    override val spicy: Boolean = false
    override val garlic: Boolean = true
  }

  println(veggieBurger1.whereAmI)
  println(veggieBurger1.spicy)
  println(veggieBurger1.typeOfBun)
}
