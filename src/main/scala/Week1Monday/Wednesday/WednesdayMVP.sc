/**
 * Tasks 1 - 3
 */
val melons: Int = 5

if (melons <= 0) {
  "This is an invalid number of melons."
} else if (melons <= 3) {
  s"John can carry $melons melons without a bag"
} else if (melons <= 5) {
  s"John needs a bag for $melons melons."
} else {
  s"$melons is too many melons for John."
}

//Task 4
val hasBag: Boolean = false

//Task 5
//if (hasBag == true) {
//  "You can buy more than 3 melons."
//} else {
//  "Go home and get a bag, John."
//}
//
//if (melons <= 5 && hasBag == true) {
//  s"John has a bag for $melons melons."
//} else {
//  "John does not need a bag"
//}

if (melons <= 0) {
  "This is an invalid number of melons."
} else if (melons <= 3) {
  s"John can carry $melons melons without a bag"
} else if (melons <= 5 && hasBag == true) {
  s"John has a bag for $melons melons."
} else if (melons <= 5 && hasBag != true) {
  s"John needs a bag for $melons melons, he can't buy them now."
} else {
  s"$melons is too many melons for John."
}

//Task 6
println(f"The total of John's $melons melons is £${melons * 1.397}%.2f.")