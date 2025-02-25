package Week4.Tuesday

import org.scalactic.Explicitly.DecidedWord

object HigherOrderFunction extends App {

  ///Higher Order Functions - HOF
  //Definition: they are a function that either takes in a function as a parameter or return a function as a result
  //Why do we use them?
  // 1. Modular, reusable code (often easier to read)
  // 2. Reduce repeated code (makes our code more concise)
  //What do they actually do? Manipulate collections(e.g. map, filter, fold, reduce, ...)


  /** HOF - functions as parameters */

  //This method will take a function that is also Int => Int and it will apply whatever that function is, to the given 'x'.
  def firstHigherOrderFunction(x: Int, function: Int => Int): Int = function(x)

  //Now need to write functions that can be passed into my HOF, ned to match the data type, in this case Int => Int
  def addTwo(number: Int): Int = number + 2

  def square(number: Int): Int = number * number

  def double(number: Int): Int = number * 2

  println(firstHigherOrderFunction(3, addTwo))
  println(firstHigherOrderFunction(3, square))
  println(firstHigherOrderFunction(3, double))

  //This method will process a list of string List[String]
  def processTheList(listOfString: List[String], function: String => String): List[String] = listOfString.map(function) //must map through the list to access the individual element

  def toUpper(word: String): String = word.toUpperCase

  def addsAnS(word: String): String = word + "s"

  def toLower(word: String): String = word.toLowerCase

  val newList: List[String] = List("dOg", "cAt", "hAmstEr", "gUIEA pIg")

  println(processTheList(newList, toUpper))
  println(processTheList(newList, addsAnS))
  println(processTheList(newList, toLower))

  processTheList(newList, toUpper) //how we call it in production code, then need to write test to see if the code is working


  /** FOLD LEFT */
  //What does it do?
  //Combines/reduces a collection into a single value
  //Process the collection from left to right
  //It will store the intermediate value as an accumulator just like recursion. Once the full collection is checked and reduced, it will return the accumulator

  //accumulator comes first, then the element (acc, element) => acc + element

  val numbersList: List[Int] = List(1, 2, 3, 4, 5)
  //Add all numbers in my list
  println(numbersList.foldLeft(0)((acc, nextInt) => acc + nextInt))
  //Shorthand: numbersList.foldLeft(0)(_+_)
  //Start with 0 -> 0 + 1 = 1 (acc = 1)
  //Next element in the list: (1, 2) => 1 + 2 = 3 (acc = 3)
  //Next element in the list: (3, 3) => 3 + 3 = 6 (acc = 6)
  //Next element in the list: (6, 4) => 6 + 4 = 10 (acc = 10)
  //Last element in the list: (10, 5) => 10 + 5 = 15 (final element in the list - we return the acc = 15)

  //fold right does the opposite, element comes first, then the accumulator (element, acc) => element + acc

  //Write a method that takes a list of "String" and returns them as a "String" (List of words into a sentence)

  val stringList = List("we", "love", "Scala")
  println(stringList.foldLeft("")((acc, word) => acc + " " + word).trim)

  //TASK 1
  //1. use a fold function to find the product of the list (multiply them all together)
  println(numbersList.foldLeft(1)((acc, nextInt) => acc * nextInt))

  //2. Use the filter method to only return the even ints from the list
  val evenNumberList = numbersList.filter(_ % 2 == 0)
  println(evenNumberList)

  //3. Use a fold function to count the numbers of characters in a string
  println(stringList.foldLeft("")((acc, word) => acc + word).size)

  //4. Use the map function to iterate through the list and transform the first letter to a capital, Then concatenate into a sentence

  println(stringList.map(stringList => stringList.capitalize).foldLeft("") ((acc, word) => acc + " " + word).trim)


  /** HOFs where the Function is the return type */

  //Commonly seen in pattern matching or if/else-statements, where we want to choose the function based on given criteria

  //Write a function where, given the length of employment, the percentage pay rise is different
  //Return the final amount paid per year to a particular employee

  case class Employee(name: String, lengthOfEmployment: Int, salary: Double)
  val Amanda = Employee("Amanda", 2, 30000.0)

  //For each of these methods we are not doing the calculation. We will use these to identify which pay rise they will get, given the criteria of employment length
  def bigPayRise: Double => Double = salary => salary * 2 //HOF
  def mediumPayRise: Double => Double = salary => salary * 1.3
  def smallPayRise: Double => Double = salary => salary * 1.1

  //This method will look at the employment length and decide which of the above methods to use
  def getPayRiseCalc(employee: Employee): Double => Double = {
    employee.lengthOfEmployment match {
      case year if year <= 3 => smallPayRise
      case year if year <= 5 => mediumPayRise
      case year if year > 5 => bigPayRise
    }
  }

  //This method will return the new salary for a given employee
  def getFinalSalary(employee: Employee): Double = {
    val applyThePayRise: Double => Double = getPayRiseCalc(employee) //store the pay rise function
    applyThePayRise(employee.salary)
  }

  println(getFinalSalary(Amanda))

  //TASK 2
  case class Item (price: Double)
  val pictureFrame = Item(56.00)
  val vase = Item(28.00)
  val fountainPen = Item(18.0)

  def bigReduction: Double => Double = price => price * 0.5 //HOF
  def mediumReduction: Double => Double = price => price * 0.6
  def smallReduction: Double => Double = price => price * 0.8


  def getPriceReductionCalc(item: Item): Double => Double = {
    item.price match {
      case price if price < 20.0 => smallReduction
      case price if price >= 20.0 && price <= 50.0  => mediumReduction
      case price if price >= 51.0 => bigReduction
    }
  }

  def getFinalPrice(item: Item): Double = {
    val applyReduction: Double => Double = getPriceReductionCalc(item)
    applyReduction(item.price)
  }
  println(getFinalPrice(pictureFrame))
  println(getFinalPrice(vase))
  println(getFinalPrice(fountainPen))
}
