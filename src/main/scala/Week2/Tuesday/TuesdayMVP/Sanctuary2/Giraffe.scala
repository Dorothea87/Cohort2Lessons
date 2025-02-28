package Week2.Tuesday.TuesdayMVP.Sanctuary2

case class Giraffe(override val name: String, override val age: Int, hasLongNeck: Boolean) extends Mammal (name, age, "yellow and brown", true, dietType = Herbivore) with Species {

  override def speciesName: String = "Giraffe"

  override def conservationStatus: String = "vulnerable"

  override def numOfYoungRange: (Int, Int) = (1, 1)

  override def avgLifespanRange: (Int, Int) = (20, 27)
}
