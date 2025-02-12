package Week2.Tuesday.TuesdayMVP

object Task2 extends App {
  //Without coding it, which of the following lines of code is runnable and which will produce an error? Then, code it and check!
  //a) case class Person(name: String, age: Int, nationality: String, isStudent: Boolean) -> should run but at long as we do not make an instance and println it, we can't see anything
  case class Person(name: String, age: Int, nationality: String, isStudent: Boolean)

  //b) val firstPerson = new Person("Carlos", 23, "Spanish", true) -> should run since it has all the necessary parameters to create a new person, we wouldn't need the new keyword though
  val firstPerson = new Person("Carlos", 23, "Spanish", true)
  println(firstPerson)

  //c) val secondPerson = Person("Carlos", 23, "Spanish", true) -> same as above, it will create a second instance of person, with the same parameters
  val secondPerson = Person("Carlos", 23, "Spanish", true)
  println(secondPerson)

  //d) val thirdPerson = Person("Chloe", 25, "British", false) -> same as above, should work because, we have all the parameters to create a new person
  val thirdPerson = Person("Chloe", 25, "British", false)
  println(thirdPerson)

  //e) class Animal(name: String, colour: String, pet: Boolean) -> this line should work, we don't need curly braces/a method to define a class
  class Animal(name: String, colour: String, pet: Boolean)

  //f) val cat = Animal("cat", "black", true) -> this line won't run because we are missing the keyword new to create a new instance of animal and class Animal isn't a case class
  //val cat = Animal("cat", "black", true)

  //g) val dog = new Animal("dog", "white", true) -> this should work again because we have the new keyword to instantiate it, but we can only access the memory location not the parameters
  val dog = new Animal("dog", "white", true)
  println(dog)
}
