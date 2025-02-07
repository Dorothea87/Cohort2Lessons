// Seq, List, Map (notice the uppercase)

val firstSeq: Seq[Int] = Seq(1, 2, 3, 4, 5)
val firstList: List[Int] = List(1, 2, 3, 4, 5)

val firstMap: Map [String, Int] = Map(
  "one" -> 1,
  "two" -> 2,
  "three" -> 3,
  "four" -> 4,
  "five" -> 5
)

// Map has key value pairs(key -> value)
// Must declare the types of both key and value in the parameters

/**
 * Accessing data
 */
//SEQ
val getSeqData: Int = firstSeq(0)
val getSeqHead: Int = firstSeq.head //get the first element (index 0)
val getSeqTail: Seq[Int] = firstSeq.tail //get everything except the head index 0
val getSeqTail = firstSeq.tail //get everything except the head index 0

val getSeqData2: Int = firstSeq(2)
//val getTooMuchData: Int = firstSeq(12) //out of bounds exception error, as we do not have any data in the 12th index position

//LIST
val getList1Data: Int = firstList(1)
val getListTail: List[Int] = firstList.tail
val getLastInList: Int = firstList.last

//MAP
val getMapData = firstMap("three") // enter the key to get the value

/** Manipulating data - using map */

val tripledList: List[Int] = firstList.map{
  number => number * 3
}
val tripledSeq: Seq[Int] = firstSeq.map{
  _ * 3
} //bad practice to not name your data type

val tripledMap: Map[String, Int] = firstMap.map {
  case (key, value) => (key, value * 3)
}

val changeKey: Map[String, Int] = firstMap.map {
  case (key, value) => (key.capitalize, value)
}

val changeKeyAndValue: Map[String, Int] = firstMap.map {
  case (key, value) => (key.capitalize, value *3)
}

/** Manipulating data - filtering */
//filter
//filterNot (works similar to !=)

val filteredSeq: Seq[Int] = firstSeq.filter(
  number => number >= 2
)
val filteredList: List[Int] = firstList.filter(
  number => number >= 2
)

filteredSeq == filteredList // returns true because it compares the results, the machine is not checking for the names of the vals but for the final value

val filteredMap: Map[String, Int] = firstMap.filter(
  number => number._2 >=2
)
// _1 --> access the key
// _2 --> access the value


//filterNot
val filterNotList: List[Int] = firstList.filterNot(
  number => number >= 2
)

val filteredList: List[Int] = firstList.filter(
  number => !(number >= 2)
)

/** Manipulating data - check if an element is present
 * will return a boolean */

  //EXISTS
val existsSeq: Boolean = firstSeq.exists(
  number => number >= 7
)
val existsList: Boolean = firstList.exists(
  number => number >= 2
)

val existsMap: Boolean = firstMap.exists(
  number => number._2 >= 2
)

  //CONTAINS - give it a specific piece of data to look for
val containsSeq: Boolean = firstSeq.contains(2)
val containsList: Boolean = firstList.contains(2)
val containsMap: Boolean = firstMap.contains("two") //checks the keys!!
val containsOrSeq: Boolean = filteredSeq.contains(7) || firstSeq.contains(2)

/** Task 1 */

//1 seq of names
val nameSeq: Seq[String] = Seq("John", "Paul", "George", "Ringo")

//2 map of colours
val colourMap: Map[Int, String] = Map (
  1 -> "red",
  2 -> "yellow",
  3 -> "blue",
  4 -> "green"
)
//Filter for blue
val filterColourMap: Map[Int, String] = colourMap.filter(
  colour => colour._2 == "blue"
)
//3 add 1 to numbers in a collection
val addOneToList: List[Int] = firstList.map{
  number => number + 1
}
//4 remove all even numbers from a collection
val filteredList: List[Int] = firstList.filter(
  number => number % 2 == 1
)
////5 return true if a seq has a string that contains the letter 'r'
//val containsLetter: Boolean = nameSeq.contains("r")

//5. Return true if a Seq has a String that contains the letter “r” .
val containsLetterR = nameSeq.exists(name => name.contains("r"))

/** Task 2 */
//1 What is a set and how is it different from Seq/Map
/**
 * There are mutable and immutable sets
 * do not contain duplicate elements
 * https://docs.scala-lang.org/overviews/collections-2.13/sets.html#inner-main
 * Three main categories of collections
 * Looking at Scala collections from a high level, there are three main categories to choose from:
 *
 * Sequences are a sequential collection of elements and may be indexed (like an array) or linear (like a linked list)
 * Maps contain a collection of key/value pairs, like a Java Map, Python dictionary, or Ruby Hash
 * Sets are an unordered collection of unique elements
 * All of those are basic types, and have subtypes for specific purposes, such as concurrency, caching, and streaming. In addition to those three main categories, there are other useful collection types, including ranges, stacks, and queues.
 *  https://docs.scala-lang.org/scala3/book/collections-classes.html#:~:text=Three%20main%20categories%20of%20collections&text=Sequences%20are%20a%20sequential%20collection,unordered%20collection%20of%20unique%20elements
 */

//2. flatMap is another cool method we can call on collections. Research what is does and when it could be useful. Write an example.
//Combo of map and flatten method. You can iterate through each item, apply a function and separate them (the inner grouping is removed). This is helpful in cases where you need to access data that is buried e.g. lists within lists.
val flatMapNames: Seq[Char] = nameSeq.flatMap(_.toCharArray) //print char
val flatMapNames: Seq[Char] = nameSeq.flatMap(_.toUpperCase) //can apply functions to each char
//returns a Seq[char] rather than strings

/** Appending and prepending to a list */

val emptyList = Seq[Int]()
emptyList :+ 1
emptyList :+ 2
emptyList
// immutable because it is a val, can't update it, need a new value every single time

val y: Seq[Int] = Seq(3, 4, 5)

//Append(add to end)
val appendY = y:+ 6

//Prepend (add at beginning)
val prependY = 2 +: appendY

val multipleInts = Seq(0,1,2) +: y
val multipleInts = Seq(0,1,2) ++ y

//Append Map

val appendMap = firstMap + ("six" -> 6)

// to order use ListMap rather than Map

/** Deletion */

val removeHead = firstSeq.tail //remove head
val removeLast = firstSeq.init //remove last index position

//map
val removeValueInMap = firstMap - "three" //call to the key
val removeMultipleValuesInMap = firstMap - ("three", "one") //call to the key