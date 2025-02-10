//Task 1: Write a method to calculate the square of an Int. It should have an input parameter, Int and return type, Int.
def squareMethod (number:Int): Int = number * number
squareMethod(5)

//Task 2: Write a method to check if a number is odd. It should have an input parameter, Int and return type, Boolean.
def checkForBoolean (number:Int): Boolean = !(number % 2 == 0)
checkForBoolean(8)

//Task 3: Using a for comprehension and your methods from MVP Q1 and Q2, write a method called sumOfOddNumbers that has an input parameter of List[Int] and return type of Int.
//This method:
//• Will iterate over a List of Int
//• Will square each Int in the List
//• Will filter and keep only the odd squared values
//• Then, return the sum of these odd squared numbers


//list of numbers
val numbers: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

def sumOfOddAndSquared(numberList:List[Int]): Int = {
  val oddSquare = for {
    numberList <- numberList //iterate over the list
    squaredNumbers = squareMethod(numberList) //calculate square (each value). Need to use = as the squareMethod
    if checkForBoolean(squaredNumbers) //use an if guard, filter and keep only the odd values of squaredNumbers
  } yield squaredNumbers // collect all the odd squares
  oddSquare.sum // sum filtered odd squares by calling your val
}
sumOfOddAndSquared(numbers)

//Task 4
//Make a simple grading system that calculates a student’s overall grade based on their scores in different subjects (Math, Science and English). The grades are given in the table below:
//For example, if a student achieves 45 in Maths, 89 in History and 60 in science, the average score would be 64.67 - they would average at a grade D overall.
//Your grading system will:
//o Calculate the average score from a list of scores.
//o Determine the grade based on the average score.


def overallGrade(history:Int, math:Int, science:Int): Double = {
  Math.round((history + math + science) / 3.0).toInt
}
//overallGrade(89, 45, 60)

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

finalGrade(89, 45, 60)