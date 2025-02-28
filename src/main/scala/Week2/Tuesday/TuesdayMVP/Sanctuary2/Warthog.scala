package Week2.Tuesday.TuesdayMVP.Sanctuary2

case class Warthog(override val name: String, override val age: Int, override val dietType: DietType, val hasTusks: Boolean) extends Mammal(name, age, "brown", true, dietType = Omnivore) with Species {
 val lionKing: String = "Hakuna Matata"

 override def speciesName: String = "Warthog"

 override def conservationStatus: String = "least concern"

 override def numOfYoungRange: (Int, Int) = (1, 8)

 override def avgLifespanRange: (Int, Int) = (15, 21)

}


