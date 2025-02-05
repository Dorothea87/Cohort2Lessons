/**
 * If statements always return values. This means we can assign values based on if statements.
 * How would we go about doing this, or where could we search to find out?
 * In the Scala documentation:
 * "if expressions always return a result
 * A great thing about the Scala if construct is that it always returns a result. You can ignore the result as we did in the previous examples, but a more common approach — especially in functional programming — is to assign the result to a variable:
 *
 * val minValue = if (a < b) a else b
 * This is cool for several reasons, including the fact that it means that Scala doesn’t require a special “ternary” operator."
 *  https://docs.scala-lang.org/overviews/scala-book/if-then-else-construct.html
 *  this makes ternaries obsolete (one line if statement)
 */

//Task 1: Create two values that hold integers. Assign any integer you'd like to these values.
val numberOne: Int = 12
val numberTwo: Int = 7

//Task 2: Create a new value to hold a string and assign it "yes" if the first value is greater than the second,
//and "no" if the second value is greater.
val numberComparison: String = if (numberOne > numberTwo) "yes" else "no"