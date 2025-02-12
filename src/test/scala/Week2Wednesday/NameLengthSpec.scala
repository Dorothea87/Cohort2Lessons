package Week2Wednesday

import Week2.Wednesday.NameLength
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class NameLengthSpec extends AnyWordSpec with Matchers {

  val nameLength = new NameLength

  "getNameLength" should {
    "return the length of the first name" when {
      "the first name is longer than the surname" in {
        val input = nameLength.getNameLength("dorothea", "toeller")
        val expectedResult = 8
        input shouldBe expectedResult
      }

    }

    "return the length of the surname" when {
      "the surname is longer than the first name" in {
        val input = nameLength.getNameLength("Mary", "Miller")
        val expectedResult = 6
        input shouldBe expectedResult

      }
    }

    "return 0" when {
      "the surname is as long as the first name" in {
        val input = nameLength.getNameLength("Marcie", "Miller")
        val expectedResult = 0
        input shouldBe expectedResult

      }
      "empty strings are entered" in {
        val input = nameLength.getNameLength("", "")
        val expectedResult = 0
        input shouldBe expectedResult

      }
    }
  }
}
