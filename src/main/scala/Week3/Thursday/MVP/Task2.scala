package Week3.Thursday.MVP

import Week2.Monday.MondayMVP.Animal
import Week3.Thursday.Options.Pizza
//2)
//a) Create a sealed trait called ‘Animal’.
//b) Create different Animals that extend the Animal trait from 2a. We are going to pattern match in 2c so consider how are going to allow for an exhaustive match.
//c) Using pattern matching, return a string, which is a fact about the animals from 2b. e.g. case Pig => "Can fly."


object Task2 extends App {

  sealed trait Animal

  case class Dog() extends Animal

  case class Budgie() extends Animal

  case class Cat() extends Animal

  case class Chameleon() extends Animal

  case class Bunny() extends Animal

  def returnAnimalFact(animal: Animal): String = {
    animal match {
      case Dog() => "Dogs can smell the past for up to 14 days."
      case Budgie() => "Budgies can rotate their heads 180 degrees."
      case Cat() => "Cats sleep about 70% of their lives."
      case Chameleon() => "Chameleons can change their colour for various reasons, e.g. to express their mood."
      case Bunny() => "Bunnies' eyes are placed on the side of their heads, which gives them almost 360 degree vision."
      case _ => "Sorry, I don't have a fun fact for these animals. Please, choose from: Dog, Cat, Budgie, Chameleon or Bunny."
    }
  }

  val aDog = Dog()

  println(returnAnimalFact(aDog))
}
