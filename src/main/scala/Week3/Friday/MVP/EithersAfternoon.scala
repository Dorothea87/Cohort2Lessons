package Week3.Friday.MVP

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success}


//1. Create two case classes, `Name` and `Postcode`
//• Both can take `value: String`
case class Name(value: String)

//10. Create companion object to `Name` and inside it:
//• Create a method called `nameOrError`, with the return type of `Either [InvalidNameError, Name]`
//• It takes in a `String` called `maybeName`
//• If the `maybeName` has a number in it, then return an `InvalidNameError`
//• If the above condition is not satisfied, return a `Name`

object Name {
  def nameOrError(maybeName: String): Either[InvalidNameError, Name] = {
    if (maybeName.exists(_.isDigit))
      Left(InvalidNameError("This is an invalid name"))
    else Right(Name(maybeName))
  }
}

case class Postcode(value: String)

//9. Create companion object to `PostCode` and inside it:
//• Create a method called `postcodeOrError` with the return type of `Either [InvalidPostcodeError, Postcode]`
//• It takes in a `String` called `maybePostCode`
//• If the `maybePostCode` is two Strings with a whitespace in between them, then return a `Postcode`. (You might need to do a little research here!!)
//• However, if the above condition is not satisfied, return an `InvalidPostcodeError
object Postcode {
  def postcodeOrError(maybePostCode: String): Either[InvalidPostcodeError, Postcode] =
    maybePostCode match {
      case postcode if postcode.split(" ").length == 2 => Right(Postcode(maybePostCode))
      case _ => Left(InvalidPostcodeError("Not a valid postcode"))
    }
}
//    if (maybePostCode.trim.contains(" ")) Right(Postcode(maybePostCode))
//    else Left(InvalidPostcodeError("This is an invalid postcode"))

//  2. Create a case class called `Letter` that contains a `name` and `postcode`
//  • The `name` should have the type `Name`
//  • The `postcode` should have the type `Postcode`
case class Letter(name: Name, postcode: Postcode)


//11. Create companion object to `Letter` and inside it:
//• Create a method called `letterOrError`
//• Pass in two `String`s called `maybeName` and `maybePostCode`
//• Using a for comprehension, use the methods `nameOrError` and `postcodeOrError` to create a `Letter`.
//• Carefully consider what the return type of the `letterOrError` method should be!
//object Letter {
//  def letterOrError(maybeName: String, maybePostcode: String): Either [GenericPostageError, Letter] = {
//    for {
//      postcode <- postcodeResult
//      name <- nameResult
//    } yield Letter(name, postcode)
//  }
//}
object Letter {
  def letterOrError(maybeName: String, maybePostcode: String): Either[GenericPostageError, Letter] =
    for {
      name <- Name.nameOrError(maybeName)
      postCode <- Postcode.postcodeOrError(maybePostcode)
    } yield {
      Letter(name, postCode)
    }
}

//3. Create a trait called `GenericPostageError`
//• Give it a parameter method `message` with a type `String`
trait GenericPostageError {
  def message: String
}

//4. Create a case class called `InvalidNameError`
//• Give it a parameter `message` with a type `String`
//• Let it be extended by `GenericPostageError`
case class InvalidNameError(message: String) extends GenericPostageError

//  5. Create a case class called `InvalidPostcodeError`
//  • Give it a parameter `message` with a type `String`
//  • Let it be extended by `GenericPostageError`
case class InvalidPostcodeError(message: String) extends GenericPostageError


object EitherLogic extends App {
  implicit val ec: ExecutionContext = ExecutionContext.global
  //  val letter: Right[GenericPostageError, Letter] = Right(Letter(Name("Simon Singh"), Postcode("AB12 CD3"))) //Q6

  //  val invalidLetter: Left[InvalidNameError, Letter] = Left(InvalidNameError("Not a name!!!")) //Q6

  val letter: Right[Nothing, Letter] = Right(Letter(Name("Simon Singh"), Postcode("AB12 CD3"))) //Q7

  val invalidLetter: Left[InvalidNameError, Nothing] = Left(InvalidNameError("Not a name!!!")) //Q7

  println("Right of a valid letter: " + letter) //Q8
  println("Left of an invalid letter: " + invalidLetter) //Q8

  val letterWithANumberInName: Either[GenericPostageError, Letter] =
    Letter.letterOrError(maybeName = "Simon Singh123", maybePostcode = "AB12 CD3") //Q12

  val letterWithAnInvalidPostcode: Either[GenericPostageError, Letter] =
    Letter.letterOrError(maybeName = "Simon Singh", maybePostcode = "AB12CD3") //Q12

  val letterAllInvalid: Either[GenericPostageError, Letter] =
    Letter.letterOrError(maybeName = "Simon Singh123", maybePostcode = "AB12CD3") //Q12

  val letterAllValid: Either[GenericPostageError, Letter] =
    Letter.letterOrError(maybeName = "Simon Singh", maybePostcode = "AB12 CD3") //Q12

  val newLetter: Letter = Letter(Name("Dorothea"), Postcode("SW18 2NX"))

  println("\nMade using the .letterOrError method:")
  println("Left of a letter due to having numbers in the name: " + letterWithANumberInName) //Q13
  println("Left of a letter due to having no space in the postcode: " + letterWithAnInvalidPostcode) //Q13
  println("Left of a letter due to having invalid name and postcode: " + letterAllInvalid) //Q13 Name error printed as checks that first, finds it invalid and then leaves the for comp.
  println("Right of a valid letter: " + letterAllValid) //Q13

  //2. Inside the EitherLogic object, create a method called `.fetchLetter`
  //• It takes no parameters.
  //• It should return a `Future [Letter]`.
  //• Any letter is fine to return here.
  //• Add in a sleep thread of 2 milliseconds. What happens?
  def fetchLetter: Future[Letter] = Future {
    Thread.sleep(1000)
    newLetter
  }

  //3. Inside the EitherLogic object, create a value called `eventualLetter` that calls `.fetchLetter` method written in MVP Q2.
  val eventualLetter = fetchLetter

  eventualLetter.onComplete{
    case Success(result) => println(s"Eventual Letter onComplete: $result")
    case Failure(exception) => println(s"Failure: $exception")
  }


  //5. Above the `Await.ready` created in MVP Q4, extract the value from the future using`.value`.
  //• Call the `eventualLetter` created this in MVP Q3 and match on it by using: eventualLetter.value match {
  //• There should be the following cases:
  //o Some(Success(foundLetter)) => ???
  //o Some(Failure(exception)) => ???
  //o None => ???
  //• Instead of ???, add a `println` to each of the above cases which inform us what has happened. Can you use s interpolation?
  val result = eventualLetter.value match {
    case Some(Success(foundLetter)) => s"Future completed: $foundLetter"
    case Some(Failure(exception)) => s"Failure: $exception"
    case None => "Future did not complete in the given time"
  }

  // futureHelloWorld.foreach(result => println(s"Using .foreach: $result"))
  //result.foreach(result => println(s"Using .foreach: $result")) //prints each character in an individual line

  //println(Await.result(combinedFutureInt, waitTime))
  println("This is me being confused: " + Await.result(eventualLetter, (2, TimeUnit.SECONDS)))

  //6. Run it. What is printed out?


  //4. At the bottom of the EitherLogic object, call the `Await.ready` method.
  //• This should pass in the ` eventualLetter` and `2.seconds` as the time.
  //• If this doesn't find an import for you, use `import scala.concurrent.duration._`
  Await.ready(eventualLetter, 2.seconds)

}

//RESEARCH - Explore error handling with Either compared to two other approaches; Try and Option.

//Either:
// - Good for expected error (e.g. validation)
// - Can be of multiple types including a Throwable
// - Makes error handling more explicit

//Try:
// - Good for unknown errors (exceptions)
// - Always of type Throwable
// - Handles capture of implicit exceptions

//Option:
// - Can handle the absence of values
// - Always of type None
// - Less informative

