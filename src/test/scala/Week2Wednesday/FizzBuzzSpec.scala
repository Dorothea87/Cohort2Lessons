package Week2Wednesday

import Week2.Wednesday.FizzBuzz
import org.scalatest.flatspec.AnyFlatSpec

class FizzBuzzSpec extends AnyFlatSpec{

  val fizzBuzz = new FizzBuzz // called it once for new instance

  "fizzBuzz" should "return 'Fizz' if the input number x can be divided by 3" in {
    assert(fizzBuzz.fizzBuzz(3) == "Fizz")

  }

  "fizzBuzz" should "return 'Buzz' if the input number x can be divided by 5" in {
    assert(fizzBuzz.fizzBuzz(5) == "Buzz")

  }

  "fizzBuzz" should "return 'FizzBuzz' if the input number x can be divided by 3 and 5" in {
    assert(fizzBuzz.fizzBuzz(15) == "FizzBuzz")

  }

//edge cases (error catching)

  "fizzBuzz" should "return x as a string if not divisible by 3 or 5" in {
    assert(fizzBuzz.fizzBuzz(13) == "13")

  }

  "fizzBuzz" should "return 0 if 0 is the original number" in {
    assert(fizzBuzz.fizzBuzz(0) == "0")

  }


}
