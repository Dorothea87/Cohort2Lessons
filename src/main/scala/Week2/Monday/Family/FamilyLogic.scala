package Week2.Monday.Family

object FamilyLogic extends App {

    //Instantiating a class (make a new object, class instance)
  //Evert time we make a new instance of a class using the keyword new, we are making and object
  new Child("Peter") //1 use
  val child1 = new Child("Peter") //reusable because you can call it with the val
  val child2 = new Child("Peter")
  println("Is child1 and 2 the same? " + (child1 == child2)) //false, each is an individual object in the memory

  println(child1.forename)
  println(child1.under18)
  // println(child1.idPlease) //cannot access because the method is private in the child class - only can be called within the class body

  val Hubert = new Child("Hubert")

  // ADULT
  val adult1: Adult = Adult.apply(new Forename("Peter"), new Surname("Parker")) //with apply method
  val adult2: Adult = new Adult(new Forename("Peter"), new Surname("Parker")) //without apply method - needs the keyword new
  println(adult1.forename) //accessing the class level of Forename
  println(adult1.forename.forename) //accessing the string inside the class level

  // DOG
  val dog1: Dog = Dog.apply(new Name("Karl"), new Age(13), new HasFood(false))
  println(dog1.name.name)
  println(dog1.areYouHungry)
}
