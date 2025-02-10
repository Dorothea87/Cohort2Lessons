/** Go back to your grading system from MVP Q4. Use functions to log
 information to the console and interact with the user. The user should
 be able to:
 a. When prompted in terminal, input the score for each subject.
 b. See the final grade printed to the terminal as a whole number. */

package Week1Monday.Friday

import scala.io.StdIn.readLine

object FridayExtensionEx3 extends App {

  println("Please enter your score for History:")
  val historyInput = readLine()
  val history = historyInput.toInt
  println("Please enter your score for Math:")
  val mathInput = readLine()
  val math = mathInput.toInt
  println("Please enter your score for Science:")
  val scienceInput = readLine()
  val science = scienceInput.toInt

  def overallGrade(history:Int, math:Int, science:Int): Double = {
    Math.round((history + math + science) / 3.0).toInt
  }

  def letterGrade(num:Double): String = {
    if (num > 100) {
      "This is an invalid value"
    } else if (num >= 90 && num <= 100) {
      "Your Grade is an A"
    } else if (num>= 80) {
      "Your Grade is a B"
    } else if (num >= 70) {
      "Your Grade is a C"
    } else if (num >= 60) {
      "Your Grade is a D"
    } else if (num <= 59 && num >= 0) {
      "Your Grade is an E"
    } else {
      "This is an invalid value"
    }
  }

  def finalGrade(history:Int, math: Int, science:Int): String = {
    val average = overallGrade(history, math, science)
    letterGrade(average)
  }

  println(f"Your final Grade is: $finalGrade(String)")
  println(s"Your final score is: $overallGrade")
}
