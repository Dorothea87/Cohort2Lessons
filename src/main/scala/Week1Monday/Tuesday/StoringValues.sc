import scala.language.postfixOps

/**
 * Melons - 50p x 5
 * Apples - 10p x 2
 * Fizzy drinks - £1.20 x 6
 * Total in pence
 */

val melons = 5 * 50
val apples = 2 * 10
val  fizzyDrinks = 6 * (100 * 1.20)
//val total = melons + apples + fizzyDrinks

//NOT best practice
var total = 0
total = total + melons

//store a val
val age = 20
//reassign a val
//age = 30

//store a var
var myAge = 37
//reassign a var
myAge = 35

/**
 * lemons - 30p x 5
 * flour - 90p x 2
 * cider - £2.50 x 6
 */

val lemons = 5 * 30
val flour = 2 * 90
val cider = 6 * (100 * 2.50)
val total = lemons + flour + cider



