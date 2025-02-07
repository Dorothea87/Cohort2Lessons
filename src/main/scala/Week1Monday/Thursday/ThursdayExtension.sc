//
// 1. Starting with a Seq of Ints from 1 to 9, come up with 2 filters that, after you’ve applied them, will return Seq(1, 2, 5, 7).
val intSeq: Seq[Int] = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9)
val filteredSeq: Seq[Int] = intSeq.filter(number => !(number % 3 == 0)).filterNot(number => number % 4 == 0)

//2. The .head function returns the first element of a list, and the .tail function returns everything except the first element. Using only the .head and .tail functions, retrieve the 3rd element of a List.
val listOfFood: List[String] = List("Chocolate", "Cake", "Cheese", "Ham", "Baguette", "Strawberries")

val getListTail: List[String] = listOfFood.tail.tail
val getListTail: String = listOfFood.tail.tail.head

//val getCheese: String = getListTail.head
