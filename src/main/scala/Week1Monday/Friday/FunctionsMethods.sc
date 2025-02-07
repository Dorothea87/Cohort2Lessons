//Examples

(number:Int) => number + 1 //Anonymous function - cannot use anywhere else
val addition = (number: Int) => number + 1 //Named function - only name it when we want to reuse it. We cannot override. Immutable

def addition (number:Int): Int = number + 1 //Method (also a type of function). Named so it can be reused. Must be named
def addition (number:Int): Int = number + 10 //Override, same name different implementation


val aValue = 2<3
def aDifferentValue: Int = {
  if (aValue) 564 else 865
  42 //last expression must match the return type
}
aDifferentValue // only 42 will be returned because it is the last expression in the method.

def makeACoffee: String = {
  "Add coffee to boiling water"
  "Add sugar or/and milk if required"
  "Stir"
  "Enjoy!"
}
makeACoffee

def makeACuppa(sugar:Int, steepTime:Int): String = {
  s"Add boiling water to your cup with a teabag, add $sugar spoons of sugar, stir and steep for $steepTime minutes. Enjoy!"
}

makeACuppa( sugar = 7, steepTime = 4)//we can name the parameter when calling the method. This is helpful for readability when the data types are the same.

val vat: Double = 1.2
//def priceIncludingVat(priceOfItem:Double): Double = {
//  priceOfItem * vat
//}
def priceIncludingVat(priceOfItem:Double): Double = priceOfItem * vat //don't need {} if only one line
priceIncludingVat(1.99)

//Task 1
def getBigVal(input1:Int, input2:Int): String = {
   if (input1 > input2) {
     "first"
   } else if (input1 < input2) {
     "second"
   } else if (input1 == input2){
     "same"
   } else {
     "Sorry, something went wrong."
   }
}
getBigVal(9, 3)

//Task 2
def nameLength(firstName:String, surname:String): Int = {
  if (firstName.length == surname.length) {
    0
  } else if (firstName.length > surname.length) {
    firstName.length
  } else if (firstName.length < surname.length) {
    surname.length
  } else {
    404
  }
}

nameLength("Chris", "Pratt")

//def nameLength(firstName:String, surname:String): Int = {
//  if (firstName.length > surname.length) {
//    firstName.length
//  } else if (firstName.length < surname.length) {
//    surname.length
//  } else {
//    0
//  }
//}
//
//nameLength("Chris", "Prats")

/** Referential transparency */
//We say something has referential transparency when a function's return value is based solely on the inputs.
//Example: addition(1,2) always = 3
def addTwoInts(x:Int, y:Int):Int = x + y
3 + 3
3 + addTwoInts(1, 2)
addTwoInts(1, 2) + addTwoInts(1, 2)
6

//Just something to bear in mind when writing more complex code. What is simpler for our brains?