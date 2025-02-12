package Week2.Tuesday.TuesdayMVP.Sanctuary2

object AnimalLogic extends App{

println("\n-----Mammal-----\n")
  val hippo = new Mammal("Gloria", 16, "grey", true)
  println(hippo.name)
  println(hippo.definitionMammal)
  println(s"Gloria has a tail? ${hippo.hasTail}")


  println("\n-----Warthog-----\n")
  val warthog1  = new Warthog("Pumbaa", 13, true)
  println(warthog1.name)
  println(s"Pumbaa, are you hungry? '${warthog1.feedMe}'")
  println(s"What is a wonderful phrase, Pumbaa: '${warthog1.lionKing}'")
  println(s"Pumbaa has a tail and tusks? That's ${warthog1.hasTail} and ${warthog1.hasTusks} ")

}
