/**
 * 1
 * The Scala documentation gives information on precedence: https://docs.scala-lang.org/tour/operators.html
 * The order is as follows:
 * ()
 * * / %
 * + -
 * :
 * < >
 * = !
 * &
 * ^
 * |
 * (all letters, $, _)
 */

//2 prediction: true (& has precedence over |)
// (true || (false && false))
true || false && false

//3 prediction: false
//((true || false) && false) => (true && false) => false
((true || false) && false)

//4 prediction: true
//(1 < 4 && 7 != 10 || 9 + 10 == 21) => (1 < 4 && 7 != 10 || 19 == 21) => (true && 7 != 10 || 19 == 21) => true && true || false => true || false =>true
(1 < 4 && 7 != 10 || 9 + 10 == 21)