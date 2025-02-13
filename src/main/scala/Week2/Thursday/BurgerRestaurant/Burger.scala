package Week2.Thursday.BurgerRestaurant

//option for double patty
//option for type of bun
//option to make it a meal

abstract class Burger(val doublePatty: Boolean, val typeOfBun: Burger.BunType) {
  def makeAMeal(fries: Boolean, drink: Boolean): String = {
  if (fries && drink ){
    "Make this a full meal!"
  } else if (fries && !drink) {
    "Make this a Fries only meal"
  } else if (!fries && drink) {
    "Make this a Drinks only meal"
  }else{
    "This is not a meal."
  }
  }
}

object Burger{
  sealed trait BunType
  case object GlutenFree extends BunType
  case object WholeGrain extends BunType
}
