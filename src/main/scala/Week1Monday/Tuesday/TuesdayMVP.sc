/**
 * Exercise 1
 */

// a) prediction: false
((3 + 4) * 57) < 300

//b) prediction: true
144 / 12 >= 12

//c) prediction: true
"Cat" < "Dog"

//d) prediction: false
"Rabbit" < "Hamster"

//e) prediction: true
17 % 2 !=0

//f) prediction: true
75 / 9 < 30 && 89 / 6 < 20

/**
 * Exercise 2
 *
 * String:
 * a string is a data type that uses text
 * it is a scala object that is represented by a sequence of characters
 *
 * Println:
 * we pass values to the console through println
 * println computes a trailing newline, compared to just print
 * we can pass any type of argument to it, not just strings
 */

/**
 * Exercise 3
 */

val name = "Dorothea"
var age: Double = 37.5

age + 10 == "you are old!"

age == 37.5
age <= 37.5
age >= 37.5
age >= 38

val newAge = 37.5 + 1

newAge == 38.5

newAge >= age

val grandma: Double = age * 2

//grandma || 74.5

(2>1) || (1>2)
(2>1) && (1>2)
(2>1) != (1>2)

(2>1) || (3>2)
(2>1) && (3>2)
(2>1) != (3>2)