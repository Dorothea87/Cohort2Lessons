package Week2.Monday.Family

class Name (val name: String)
class Age (val age: Int)
class HasFood (val hasFood: Boolean)

class Dog (val name: Name, val age: Age, val hasFood: HasFood ) { // type safe because we are using classes as types.
  def petsPlease: String = "Can I please get an ear scratch?"
//  def areYouHungry: String =  if (hasFood.hasFood) "You are not hungry!" else "I will feed you in a minute."
}

object Dog {
  def apply(name: Name, age: Age, hasFood: HasFood): Dog = new Dog(name, age, hasFood)
}
