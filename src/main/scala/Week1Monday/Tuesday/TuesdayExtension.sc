/**
 * Exercise 1
 */

"STRING"  == "string" //case sensitivity

/**
 * Exercise 2
 */
//val one: String = "one"
//val numberOne: Int = one.toInt
//println(numberOne)
//this only works with a numeric string such as "1"

/**
 * Exercise 3
 */
val number: Int = 1
val str: String = number.toString
println(str)

/**
 * Exercise 4
 * I think you cannot directly convert a number to a string, you need to first store everything in variables before you can use an in-built method
 */

/**
 * Exercise 5
 */
val lowerCaseString: String = "hello world"
val upperCaseString = lowerCaseString.toUpperCase()
//println(upperCaseString)

/**
 * Exercise 6
 * first we need to split the string into words
 * then capitalise each word
 * then join it together with spaces into one string
 */
val capitalisedString = lowerCaseString.split(" ").map(word => word.capitalize).mkString(" ")
