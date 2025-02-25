package Week4.Tuesday.MVP

object AfternoonTasks extends App {

  //1 a. Create a function called `intDoubler` that takes an input of type `Int` and returns an `Int`. This method will return the input `Int` doubled.
  def intDoubler(input: Int): Int = input * 2

  //b. Create a second function called ‘applyTwice’ that takes two parameters.
  //i. The first parameters is an `input:Int`.
  //ii. The second parameter is a function called `f` that takes an `Int` and returns an `Int`. (Having this as parameter makes the `applyTwice` method a higher order function.)
  //iii. The `applyTwice` function must apply `f` twice in succession to the `input`.
  def applyTwice(input: Int, f: Int => Int): Int = f(input) * 2

  //c. Call the `applyTwice` function passing in the ` intDoubler ` as your `f`. (E.g. applyTwice(4, intDoubler) should equal 16)
  println(applyTwice(4, intDoubler))
  println(applyTwice(100, intDoubler))

  //2 a. Create 4 functions (addition, multiplication, division, subtraction), each take two doubles as inputs and return a Double as the result.
  def addition(x: Double, y: Double): Double = x + y
  def subtraction(x: Double, y: Double): Double = x - y
  def multiplication(x: Double, y: Double): Double = x * y
  def division(x: Double, y: Double): Double = x / y

  //b. Create a function called 'IntManipulator' that takes in two doubles, and a mathematical operation (as made above) as a function and returns the result as a double.
  def intManipulator(num1: Double, num2: Double, function: (Double,Double) => Double): Double = function(num1, num2)

  println(intManipulator(5.0, 3.0, addition))
  println(intManipulator(5.0, 3.0, subtraction))
  println(intManipulator(5.0, 3.0, multiplication))
  println(intManipulator(5.0, 3.0, division))


}
