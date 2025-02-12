package Week2.Tuesday.TuesdayMVP.Sanctuary2

case class Warthog(override val name: String, override val age: Int, val hasTusks: Boolean) extends Mammal(name, age, "brown", true) with Omnivore{
 val lionKing: String = "Hakuna Matata"
}
