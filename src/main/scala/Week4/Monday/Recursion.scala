package Week4.Monday

import scala.annotation.tailrec

object Recursion extends App {

  //Standard recursion
  //recursive calls which call the original method inside the method
  //each new call adds to the call stack
  //method will remember all of these calls before completing
  //will continue to recursively call until the base case is reached (breaks the loop)
  //Once the base case is reached, it will resolve in reverse order

  //Factorial method - multiply all positive Ints in a list (input = 4 --> 4x3x2x1)

  def factorial(n: Int): Int = {
    if (n <= 1) { //HOW I ESCAPE THE RECURSION
      1 //base case (breaks the loop), when you get to 1, return 1 and then the stored call stack can start unwinding
    } else {
      println(s"Incoming n is: $n")
      println(s"New n is: {$n-1}")
      val finalResult = n * factorial(n - 1)
      println(s"Final n call: $n")
      finalResult
    }
  }

  println(factorial(4))
  //Pseudocode unwinding stack - factorial(4)
  //Recursive loop - call stack -- not yet evaluated (waiting until the loop ends to evaluate)
  //factorial(4) --> 4 * factorial(4-1 = 3) --> factorial(3) - Bottom of the stack
  //factorial(3) --> 3 * factorial(3 -1 = 2) --> factorial(2)
  //factorial(2) --> 2 * factorial(2 -1 = 1) --> factorial(1) - top of the stack
  //factorial(1) --> hits the base case in the if, exits the recursive loop --> return 1
  //UNWIND --> top to bottom
  // factorial(2) --> 2 * factorial(2-1) --> 2 * factorial(1) --> 2 * 1 = 2
  // factorial(3) --> 3 * factorial(3-1) --> 3 * factorial(2) --> 3 * 2 = 6
  // factorial(4) --> 4 * factorial(4-1) --> 4 * factorial(3) --> 4 * 6 = 24
  //Final result = 24

  //Stack overflow errors - there is only so much memory in the call stack. If this is exceeded we get this error
  //  println(factorial(10000))

  /** TAIL RECURSION */
  //Smarter way to write recursion because it stops stack overflow errors.
  //Key differences:
  //1. recursive call must be the last operation a function performs. (@tailrec - will check this)
  //2. Prevents stack overflow error:
  // a)Doesn't need to remember all previous values, all needed information is passed through as an accumulator (acc)
  // b)Scala replaces the recursive calls with a really simple loop under the hood, called a Tail call optimization (TCO)
  //Replaces and updates the accumulator with every recursive call

  //1st - with a helper method

  def smarterFactorial(n: Int): Int = {
    @tailrec
    def factorialHelper(x: Int, acc: Int): Int = {
      if (x <= 1) acc
      else {
        println(s"Current X: $x")
        println(s"Value of current acc: $acc")
        factorialHelper(x - 1, acc * x)
      }
    }

    factorialHelper(n, 1)
  }

  println("\nTail rec with helper: " + smarterFactorial(4))

  //Does the whole calculation with one value, stores the value in an accumulator, does the whole calculation again, no need to store all the values first and then unwind

  // def smarterFactorial(n: Int): Int = {
  //    @tailrec
  //    def factorialHelper(x: Int, acc: Int): Int = { // helper - don't have to change the original method signature
  //      if (x <= 1) acc // acc = superstar - stores the intermediate value, don't need to have a large memory as call stack is being updates each time (store, update, pass every single time)
  //      else {
  //        println(s"Current X: $x")
  //        println(s"Value of current acc: $acc")
  //        factorialHelper(x-1, acc * x) // last expression  = tail recursion, Override old values and pass in a new updated accumulator each time.
  // x -1 --> moving down our numbers list
  //acc * x --> running total
  //      }
  //    }
  //    factorialHelper(n, 1) // call the helper, pass in the original n, so we start the recursion at the top level, accumulator will start at whatever our if-case is
  //  }
  //  println("\nTail rec with helper: " + smarterFactorial(4))


  //** TAIL RECURSION WITHOUT HELPER METHOD */
  @tailrec
  def smarterFactorialWithoutHelper(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else smarterFactorialWithoutHelper(n - 1, acc * n)
  }

  println("\nTail recursion without helper method: " + smarterFactorialWithoutHelper(4))

  //* Example with string */

  def concatenateWords(aWord: String, n: Int, acc: String): String = {
    if (n <= 0) {
      println(s"Current aWord inside if: $aWord")
      println(s"Current acc inside if: $acc")
      acc
    }
    else {
      println(s"Current aWord inside else: $aWord")
      println(s"Current acc inside else: $acc")
      concatenateWords(aWord, n - 1, aWord + acc)
    }
  }
    println(concatenateWords("Hello World", 3, ""))

  //TASK 1
  //method that takes a list of strings and returns an Int
  def countStrings(list: List[String]): Int = {
    if (list.isEmpty) {
      0 //if the list is empty return zero (base case)
    } else {
      1 + countStrings(list.tail) // Recursive case, count the first element, count again until nothing left in the list
    }
  }

  val letterList: List[String] = List("a", "b", "c")
    println(countStrings(letterList))

  @tailrec
  def smarterStringCount(list: List[String], acc: Int = 0): Int = {
    if (list.isEmpty) acc
    else smarterStringCount(list.tail, acc + 1)
  }
}



