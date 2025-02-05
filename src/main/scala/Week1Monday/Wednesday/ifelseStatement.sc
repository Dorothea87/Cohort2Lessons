/**
 * if else statement
 */

//Depending on the weather, tell me what to wear.

val weather: String = "hot"

if (weather == "hot") {
  s"It is $weather, no coat needed."
} else {
  s"You need a coat, it is $weather."
}

// if true --> hits the first string inside the 'if'
// if false --> hits a second string inside the 'else'

if (weather.toLowerCase == "hot") {
  s"It is $weather, no coat needed."
} else if (weather.toLowerCase == "raining") {
  s"It is $weather, take a coat with a hood."
} else {
  s"$weather is not valid, please enter raining or hot."
}

//always reads from top to bottom, eliminate certain options first

//Multiple options
val season: String = "summer"

if (weather.toLowerCase == "cold" || season.toLowerCase == "winter") {
  s"It is $weather, please take a coat."
} else {
  "A light jacket is fine."
}

/**
 * Tasks
 */

//Task 1
//use conditions to calculate somebody's grade given the percentage they scored

val percentageGrade: Int = 79

if (percentageGrade > 100) {
  "This is an invalid value"
} else if (percentageGrade >= 90 && percentageGrade <= 100) {
  "Your Grade is an A"
} else if (percentageGrade >= 80) {
  "Your Grade is a B"
} else if (percentageGrade >= 70) {
  "Your Grade is a C"
} else if (percentageGrade >= 60) {
  "Your Grade is a D"
} else if (percentageGrade >= 50) {
  "Your Grade is an E"
} else if (percentageGrade <= 49 && percentageGrade >= 0) {
  "Your Grade is an F"
} else {
  "This is an invalid value"
}

//Task 2
//Use conditions to work out for a given age, what film ratings they can see

val childAge: Int = 7

if (childAge >= 18) {
  "You can watch all movies"
} else if (childAge >= 15) {
  "You can watch U, PG, 12A and 15+ movies"
} else if (childAge >= 12) {
  "You can watch U, PG and 12A movies"
} else if (childAge >= 8) {
  "You can watch U or PG movies"
} else if (childAge >= 4) {
  "You can watch U movies"
} else

