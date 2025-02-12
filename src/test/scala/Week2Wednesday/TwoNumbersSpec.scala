package Week2Wednesday

import Week2.Wednesday.TwoNumbers
import org.scalatest.flatspec.AnyFlatSpec

class TwoNumbersSpec extends AnyFlatSpec {

  "add" should "add the two Int that are class parameters" in {
    val numbers = new TwoNumbers(3, 4) //making a new instance of my class, so I can access the methods.
    assert(numbers.add == 7) //this will return a Boolean. Method == Expected
  }

  "subtract" should "subtract x from y" in { // y - x = 4 - 3
    val numbers = new TwoNumbers(3, 4)
    assert(numbers.subtract == 1)
  }

  "multiply" should "multiply x by y" in {
    val numbers = new TwoNumbers(3, 4)
    assert(numbers.multiply == 12)
  }
//We want to test edge cases. We want our tests top be able to fail, but they still need to compile
  //THIS DOES NOT COMPILE BECAUSE WE DON'T KNOW OPTION STATEMENTS YET
//  "multiply" should "error when the input is a double" in {
//    val numbers = new TwoNumbers(3.5, 4)
//    assert(numbers.multiply != 14)
//  }
}
