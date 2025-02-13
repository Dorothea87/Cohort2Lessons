//These work on monadic types -- Seq, List, Option, Either, Future
//Won't work in standard Int, String and Boolean

// <- (backwards arrow), simplified way of writing a function (flatmap, filter, map, foreach)
//yield -- call the map

// classic for comprehension
def retrieveNumbers: Seq[Int] = for (number <- 1 to 10) yield number
retrieveNumbers
// (1 to 10).foreach(number => println(number))

//use operators
def squaredNumbers: Seq[Int] = for (number <- 1 to 5) yield number * number
squaredNumbers

//if guards
def useAnIfGuard: Seq[Int] = for (number <- 1 to 10 if number % 2 == 0) yield number
useAnIfGuard

val animals: List[String] = List("Giraffe", "Bear", "Otter", "Penguin")

def addS(animalList:List[String]): List[String] = animalList.map(animal => animal + "s")
addS(animals)

def lowerCaseAnimals(animalList: List[String]): List[String] = animalList.map(animal => animal.toLowerCase)
lowerCaseAnimals(animals)

def lowercaseAndAddS(animalList:List[String]): List[String] = for {
  addAnS <- addS(animalList)
  lowerCase <- lowerCaseAnimals(List(addAnS))
} yield lowerCase
lowercaseAndAddS((animals)).mkString(", ")

//Task 1

val names: List[String] = List("aRIa", "BaRT", "ChuCk")

def lowerCase(nameList: List[String]): List[String] = nameList.map(name => name.toLowerCase)
lowerCase(names)

def capitalizeName(nameList: List[String]): List[String] = nameList.map(name => name.capitalize)
capitalizeName(names)

def lowercaseAndCap(nameList:List[String]): List[String] = for {
  lowerCaseName <- lowerCase(nameList)
  capName <- capitalizeName(List(lowerCaseName))
} yield capName
lowercaseAndCap((names)).mkString(", ")



































