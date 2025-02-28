package Week2.Tuesday.TuesdayMVP.Sanctuary2

abstract class Animal(val name: String, val age: Int, val dietType: DietType){
  val myName: String = s"My name is $name."
}


  sealed trait DietType

  case object Omnivore extends DietType

  case object Carnivore extends DietType

  case object Herbivore extends DietType
