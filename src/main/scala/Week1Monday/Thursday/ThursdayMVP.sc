/** Task 1 */
//a) Make a List of the numbers from 1-5, and a Seq of the primary colours.
val listOfNumbers: List[Int] = List(1, 2, 3, 4, 5)
val seqOfPrimaryColours: Seq[String] = Seq("yellow", "blue", "red")

//b) Write a function to multiply all the values in your List by 3.
val tripledList: List[Int] = listOfNumbers.map{
  number => number * 3
}

//c) Write a function that removes “Blue” from your Seq.

val filteredSeq: Seq[String] = seqOfPrimaryColours.filter(
  word => !(word == "blue")
)

//d) Write a function that returns ‘true’ if your Seq contains “Orange”.
//val appendY = y:+ 6
val extendedColours = seqOfPrimaryColours:+ "orange"
val onangeIsNotPrimary: Boolean = extendedColours.exists(
  word => word == "orange"
)

/** Task 2
 * Write a function that maps each value in your List to true or false, depending on whether they
 are odd. */
val booleanList: List[Boolean] = listOfNumbers.map{
  number => number % 2 == 0
}
/** Task 3
 * David has many pets; 2 dogs, 1 fish and 1 cat. */
//a) Make a Map which details the key -> value pair of “Name” -> “Animal”.
val davidsPets: Map [String, String] = Map(
  "Gromit" -> "dog",
  "Snoopy" -> "dog",
  "Tom" -> "cat",
  "Dori" -> "fish"
)
//b) Write a function that returns a List of the names of David’s dogs.
val davidsDogs: Map[String, String] = davidsPets.filter(pet => pet._2 == "dog")

//The tangent
val davidsOtherPets: Map[String, List[String]] = Map(
  "dog" -> List("Fluffy", "Waggy"),
  "cat" -> List("Scratchy"),
  "fish" -> List("Swimmy")
)

davidsOtherPets.filter(pet => pet._1 == "dog").values
davidsOtherPets.filter(pet => pet._1 == "dog").values.flatten
davidsOtherPets.filter(pet => pet._1 == "dog").values.flatten.mkString
davidsOtherPets.filter(pet => pet._1 == "dog").values.flatten.mkString(", ")