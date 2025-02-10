package Week2.Monday.MondayMVP

class Name (val name: String)
class Age (val age: Int)

class Animal (val name: Name, val age: Age) {
 val notHuman: Boolean = true
}

object Animal {
  def apply(name: Name, age: Age): Animal = new Animal(name, age)
}