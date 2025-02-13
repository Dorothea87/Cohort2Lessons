package Week2.Thursday.BurgerRestaurant

trait Sauces {
  //add method here
  def whereAmI: String = "I am in Sauces!"
}

trait Ketchup extends Sauces {
  val spicy: Boolean
}
trait Mayo extends Sauces {
  val garlic: Boolean = false
}
trait Relish extends Sauces
trait Mustard extends Sauces
