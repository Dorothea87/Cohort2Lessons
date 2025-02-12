package Week2Wednesday

import Week2.Wednesday.Username
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class UsernameSpec extends AnyWordSpec with Matchers {


  //Make a new instance of my class
  //Do this at the top level because my class does not take parameters (only my method does)
  //Because it is declared at top level, I can access this class now anywhere between the yellow curly braces, which is my class body
  val username = new Username

  "checkUsername" should {
    "return true" when {
      "the username is 8 characters long and all lowercase" in {
        val input = username.checkUsername("dorothea")
        val expectedResult = true
        input shouldBe expectedResult
      }

      "the username is more than 8 characters long and all lowercase" in {
        val input = username.checkUsername("dorotheatoeller")
        val expectedResult = true
        input shouldBe expectedResult
      }
    }
    "return false" when { //this is a passing test, but it is written to prove that my method can fail (can get to my else case)
      "the username is less than 8 characters long but all in lower case" in {
        val input = username.checkUsername("anna")
        val expectedResult = false
        input shouldBe expectedResult
      }

      "the username is 8 characters long but contains upper case" in {
        val input = username.checkUsername("Dorothea")
        val expectedResult = false
        input shouldBe expectedResult
      }

      //edge cases
      "the username is entered as an empty" in {
        val input = username.checkUsername("")
        val expectedResult = false
        input shouldBe expectedResult
      }


    }


  }
}
