package Week2.Tuesday.TuesdayMVP.Sanctuary2

object AnimalLogic extends App{

println("\n-----Mammal-----\n")
  val hippo = new Mammal("Gloria", 16, "grey", true, dietType = Omnivore)
  println(hippo.name)
  println(hippo.definitionMammal)
  println(s"Gloria has a tail? ${hippo.hasTail}")


  println("\n-----Warthog-----\n")
  val warthog1  = Warthog("Pumbaa", 13, hasTusks = true, dietType = Omnivore)
  println(warthog1.name)
//  println(s"Pumbaa, are you hungry? '${warthog1.fe}'")
  println(s"What is a wonderful phrase, Pumbaa: '${warthog1.lionKing}'")
  println(s"Pumbaa has a tail and tusks? That's ${warthog1.hasTail} and ${warthog1.hasTusks} ")
  println(warthog1.avgLifespanRange)
  println(warthog1.hasTail)


  println("\n-----Giraffe-----\n")
  val giraffe1 = Giraffe("Melmon", 15, hasLongNeck = true)
  println(giraffe1.name)
  println(giraffe1.definitionMammal)
  println(giraffe1.dietType)

}
