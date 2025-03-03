package Week4.Tuesday.MVP

object AfternoonTasks extends App {

  //1 a. Create a function called `intDoubler` that takes an input of type `Int` and returns an `Int`. This method will return the input `Int` doubled.
  def intDoubler(input: Int): Int = input * 2

  //b. Create a second function called ‘applyTwice’ that takes two parameters.
  //i. The first parameters is an `input:Int`.
  //ii. The second parameter is a function called `f` that takes an `Int` and returns an `Int`. (Having this as parameter makes the `applyTwice` method a higher order function.)
  //iii. The `applyTwice` function must apply `f` twice in succession to the `input`.
  def applyTwice(input: Int, f: Int => Int): Int = f(f(input))

  //c. Call the `applyTwice` function passing in the ` intDoubler ` as your `f`. (E.g. applyTwice(4, intDoubler) should equal 16)
  println(applyTwice(4, intDoubler))
  println(applyTwice(100, intDoubler))

  //2 a. Create 4 functions (addition, multiplication, division, subtraction), each take two doubles as inputs and return a Double as the result.
  def addition(x: Double, y: Double): Double = x + y

  def subtraction(x: Double, y: Double): Double = x - y

  def multiplication(x: Double, y: Double): Double = x * y

  def division(x: Double, y: Double): Double = x / y

  //b. Create a function called 'IntManipulator' that takes in two doubles, and a mathematical operation (as made above) as a function and returns the result as a double.
  def intManipulator(num1: Double, num2: Double, function: (Double, Double) => Double): Double = function(num1, num2)

  println(intManipulator(5.0, 3.0, addition))
  println(intManipulator(5.0, 3.0, subtraction))
  println(intManipulator(5.0, 3.0, multiplication))
  println(intManipulator(5.0, 3.0, division))

  //3 a. Create a function called `convertToUpperCase` that take any string input and returns that string as uppercase.
  def convertToUpperCase(input: String): String = input.toUpperCase

  //b. Create a function called `convertToLowerCase` that take any string input and returns that string as lowercase.
  def convertToLowerCase(input: String): String = input.toLowerCase

  //c. Create a third function called `stringConverter` that takes a Boolean input with parameter name `makeStringUpperCase`. If the input is 'true' return the upperCase method, if false return the lowerCase method.
  def stringConverter(input: String, makeStringUpperCase: Boolean): String = {
    if (makeStringUpperCase) {
      convertToUpperCase(input)
    } else {
      convertToLowerCase(input)
    }
  }

  //d. Copy `val testString = “cOnVeRtMe”` and apply your convertString method to your testString and print the result when the input is ‘true’ and when it is ‘false’.
  val testString = "cOnVeRtMe"
  println(stringConverter(testString, true))
  println(stringConverter(testString, false))

  //4 a. Create a `calculate` method that takes an input called `operation: String` and pattern matches it to return one previously written methods from question 2; ‘add’, ‘subtract’, ‘multiply’, and ‘divide’. (Example: calculate(“add”) will return the add method from Q2)
  def calculate(operation: String): (Double, Double) => Double = {
    //insert pattern matching here
    operation match {
      case "add" => addition
      case "subtract" => subtraction
      case "multiply" => multiplication
      case "divide" => division
    }
  }
  //b. Try applying different string inputs to the calculate method to return each of the arithmetic methods.
  val addFunc = calculate("add")
  val subtractFunc = calculate("subtract")
  val multiplyFunc = calculate("multiply")
  val divideFunc = calculate("divide")

  //c. What happens if you enter an input that doesn’t match any of the methods? Should we account for this in our pattern match? What would change if we did?
  def calculateWithEitherReturn(operation: String): Either[String, (Double, Double) => Double]  = {
    operation match {
      case "add" => Right(addition)
      case "subtract" => Right(subtraction)
      case "multiply" => Right(multiplication)
      case "divide" => Right(division)
      case _ => Left("Enter a valid method; add, subtract, multiply or divide.")
    }
  }
}
