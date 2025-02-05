/**
 * String Interpolation
 */

//s

val name: String = "Dorothea"

println(s"My name is $name.") //$ tells Scala what val to look for

println(s"3 x 3 = ${3*3}")

val a: Int = 19764
val b: Int = 67
println(s"a x b = ${a*b}")

// Helpful for debugging
//Print the result at certain points in a method

//f
//Common format specifiers (type safety)
//%f - float, double
//%d - Int, Long
//%s - String

val height: Double = 1.68
println(f"$name%s is $height%.2f metres tall ") // 2 d.p.
println(f"$name%s is $height%.1f metres tall ") // 1 d.p.
println(s"$name%s is $height%.1f metres tall ") // s interpolation won't recognise formatting

math.Pi //build in library
println(f"Pi to 2 d.p is ${math.Pi}%.2f")
println(f"Pi to 2 d.p is ${math.Pi}%.5f")
println(f"Pi to 2 d.p is ${math.Pi}%20.5f") //add some padding

//printf - String
printf("'%s'", "Hello")
printf("'%20s'", "Hello") //padding before
printf("'%-20s'", "Hello")// padding after
printf("'%20s%-20s'", "Hello", "") //padding before and after

//raw

println(s"I'm going onto a \nnew line") //s will drop everything after \n into a new line
println(raw"I'm going onto a \nnew line") //raw will ignore commands and print everything as is
//Common use case of raw --> Regex

/**
 * Tasks
 */

//1
 val name2: String = "Ash"
println(s"$name2 is older than $name")

//2
val age1: Int = 37
val age2: Int = 39
println(s"$name2 is ${age2 - age1} years older than $name")

//3
val age1Double: Double = 37.5
val age2Double: Double = 39.5
println(f"$name2 is ${age2Double - age1Double}%.2f years older than $name")

//4
println(raw"\n\n\n\n\n\n\n\nsameline\n\n")
