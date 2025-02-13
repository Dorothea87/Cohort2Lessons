/**
 * Int - whole numbers --> anything worth up to 4 bytes of memory
 * Long - whole number --> up to 8 bytes
 * Short - whole number --> up to 2 bytes
 * Double - simple decimal (same as in java)
 * Float - 2.0f (not used a lot, compiles on smaller memory, short of decimals)
 * String - "Text"
 */

val one: Int = 1
val inferredOne = 1 //Haven't told Scala it is an Int - it has inferred the type, not safe, tell the type explicitly


val int: Int = 3000
val name: String = "Dorothea"
val aLie: Boolean = false


//Task 2
val double: Double = 2.65
val biggestInt: Int = 2147483647
val long: Long = 2147483690L