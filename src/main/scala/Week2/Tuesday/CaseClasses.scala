package Week2.Tuesday

object CaseClasses extends App {

  //Standard Class
  //  class SuperHero( val realName: String, val heroName: String, val weakness: String)
  //  new SuperHero("Clark Kent", "Superman", "Kryptonite") //made a new instance of SuperHero as an object from the SuperHero class

  //Case class
  case class SuperHero(realName: String, heroName: String, weakness: String) //each parameter is a val by default

  val spiderMan = SuperHero.apply("Peter Parker", "Spider-man", "Ethyl Chloride") //.apply method is built in. Object made using the SuperHero case class
  val spiderMan1 = SuperHero.apply("Peter Parker", "Spider-man", "Ethyl Chloride")
  println(spiderMan1 == spiderMan) //true - compares the field values not the object reference/memory location

  //.copy method
  val copiedSpiderMan = spiderMan.copy(weakness = "Spider Slayer Squad") //Make a new val! Not mutating the original
  println((copiedSpiderMan.weakness))
  println(spiderMan.weakness) //original is not being reassigned
  val updatedName = spiderMan.copy(realName = "Andy Probert", weakness = "pints")
  println(updatedName.realName + updatedName.weakness)

  //TASK
  println("\nTask\n")

  //1
  case class Dog(name: String, age: Int, breed: String)

  //2
  val dog1 = Dog.apply("Pumba", 13, "Mongrel")
  val dog2 = Dog.apply("Snoopy", 4, "Beagle")
  val dog3 = Dog.apply("Scooby-Doo", 2, "Great Dane")
  val dog4 = Dog.apply("Marley", 12, "Golden Retriever")

  //3
  case class Kennel(name: String, dogs: List[Dog])

  //4
  val dorotheaDoghouse = Kennel.apply("Dorothea's Doghouse", List(dog1, dog2, dog3, dog4))
  println(dorotheaDoghouse.name)
  println(dorotheaDoghouse.dogs)

  //5
  val copiedKennel = dorotheaDoghouse.copy(name = "Mercator Dogs")
  println(copiedKennel)
  println(copiedKennel.name)

  //A make a cat case class and a bird case class
}


