package Week2.Monday.MondayMVP

object SanctuaryLogic extends App {
//  val animal1: Animal = Animal.apply(new Name("Crocodile"), new Age(12))
//
//  println(animal1.age.age)
  val pumba = new Warthog ( name = "Pumba", age = 13, hasTusk = true)
  println(pumba.name)
  println(pumba.isMammal)
}
