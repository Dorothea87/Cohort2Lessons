package Week4.Monday.MVP

import scala.annotation.tailrec

object Tasks3and4 extends App {

  //3) Create a method that has an input of a positive Int. This method will return the sum of all numbers between 0 and the input Int.
  //• For example, if we input 5, then the output should be 5+4+3+2+1 = 15.
  //• This is similar to the Factorial method but uses addition instead of multiplication.

  def addNumbers(n: Int): Int = {
    if (n <= 1) {
      1
    } else {
      val additionResult = n + addNumbers(n - 1)
      additionResult
    }
  }

  println(addNumbers(5))

  def addNumbers1(n: Int): Int = {
    n match {
      case x if x <= 1 => 1
      case x => x + addNumbers(x - 1)
    }
  }

  println(addNumbers1(5))

  def easierAddNumbers(n: Int): Int = {
    @tailrec
    def factorialHelper(x: Int, acc: Int): Int = {
      if (x <= 1) acc
      else {
        factorialHelper(x - 1, acc + x)
      }
    }

    factorialHelper(n, 1)
  }

  println(easierAddNumbers(5))

  //4) Using recursion and given a list with all integers from 1 to 20 inclusive, create a method called “isEven” that checks if a number, at a given index position, is even or not. The return type of this method should be Either [String, Boolean].

  //check if n is in the list
  //loop over the list and check if the index position is even or odd, should return sth like false, true, false, true,...
  //right should be a string that says is not odd, left should be true
  //incorporate edge cases like 0 or numbers higher than numbers in list

  //  val intList = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
  //
  //  def isEven(index: Int, lst: List[Int]): Either[String, List[Boolean]] = {
  //    if (index < 0 || index > lst.length) {
  //      Left("This is an invalid Int, must be either more than 0 or less than 21.")
  //    } else {
  //        if (lst(index) % 2 == 0) {
  //          Right(true)
  //        } else {
  //          Right(false)
  //        }
  //    }
  //
  //  }
  //  println(isEven(5, intList))
  ////}

  val intList = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)

  def isEven(index: Int, lst: List[Int]): Either[String, List[Boolean]] = {
    if (index < 0) {
      Right(List())
    } else if (index >= lst.length) {
      Left("This index is out of bounds.")
    } else {
      val currentResult = lst(index) % 2 == 0
      isEven(index - 1, lst) match {
        case Right(results) => Right(currentResult :: results)
        case Left(error) => Left(error)
      }
    }
  }

  println(isEven(5, intList))
  println(isEven(25, intList))
  println(isEven(19, intList))
}
