package Week2.Monday.Family

class Child (val forename: String){ // () - class parameters {} - body of the class. All the logic goes in the body

  val under18: Boolean = true
  private def idPlease: String = "Can I see your Id?"
}


//Companion object
object Child {
  def apply(forename: String): Child = new Child(forename) //shorthand to make new instances of a class.

  //Access the companion classes private method
  val bob = Child.apply("Bob")
  println(bob.idPlease)
}