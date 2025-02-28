package Week3

import Week3.Friday.MVP.EitherLogic.{fetchLetter, newLetter}
import Week3.Friday.MVP.{InvalidNameError, InvalidPostcodeError, Letter, Name, Postcode}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future, ExecutionContext}



class EithersAfternoonSpec extends AnyWordSpec with Matchers {


  "postcodeOrError" should {
    "return a Right with a postcode" when {
      "the postcode entered is valid" in {
        val correctPostcode = Postcode.postcodeOrError("SW18 2NX")
        correctPostcode shouldBe Right(Postcode("SW18 2NX"))
      }
    }
    "return a Left with the error message 'Not a valid postcode'" when {
      "an invalid postcode is entered which does not contain an empty space in the middle" in {
        val incorrectPostcode = Postcode.postcodeOrError("ABCDEF1")
        incorrectPostcode shouldBe Left(InvalidPostcodeError("Not a valid postcode"))
      }
    }
  }

  "nameOrError" should {
    "return a Right with a valid name" when {
      "the name entered is valid" in {
        val correctName = Name.nameOrError("Dorothea")
        correctName shouldBe Right(Name("Dorothea"))
      }
    }
    "return a Left with the error message 'this is an invalid name'" when {
      "the name entered is invalid because it contains digits" in {
        val incorrectName = Name.nameOrError("P1ter")
        incorrectName shouldBe Left(InvalidNameError("This is an invalid name"))
      }
    }
  }

  "letterOrError" should {
    "return a Right which is a valid Letter" when {
      "a correct Name and Postcode are given" in {
        val inputName = Name("Dorothea")
        val inputPostcode = Postcode("SW18 2NX")

        val input = Letter.letterOrError("Dorothea", "SW18 2NX")

        input shouldBe Right(Letter(inputName, inputPostcode))

      }
    }

    "return a Left which is an invalid Letter" when {
      "a correct Name and an invalid Postcode are given" in {
        val inputName = Name("Dorothea")
        val inputPostcode = Postcode("2NX")

        val input = Letter.letterOrError("Dorothea", "2NX")

        input shouldBe Left(InvalidPostcodeError("Not a valid postcode"))

      }
    }

    "return a Left which is an invalid Letter" when {
      "an incorrect Name and a valid Postcode are given" in {
        val inputName = Name("Doro111thea")
        val inputPostcode = Postcode("SW18 2NX")

        val input = Letter.letterOrError("Doro111thea", "SW18 2NX")

        input shouldBe Left(InvalidNameError("This is an invalid name"))

      }
    }

    "return a Left which is an invalid Letter" when {
      "an incorrect Name and an invalid Postcode are given" in {
        val inputName = Name("Doro111thea")
        val inputPostcode = Postcode("2NX")

        val input = Letter.letterOrError("Doro111thea", "2NX")

        input shouldBe Left(InvalidNameError("This is an invalid name"))

      }
    }
  }

//  "fetchLetter" should {
//    "return a letter" when {
//      "the method is executed" in {
//        val inputName = Name("Dorothea")
//        val inputPostcode = Postcode("SW18 2NX")
//        val expectedLetter = Letter(inputName, inputPostcode)
//
//        val result: Future[Letter] = fetchLetter
//        val letter: Letter = Await.result(result, 2.seconds)
//
//        letter shouldEqual expectedLetter
//      }
//    }
//  }
}
