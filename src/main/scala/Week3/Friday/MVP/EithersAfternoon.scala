package Week3.Friday.MVP


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
    if (maybeName.exists(_.isDigit)) Left(InvalidNameError("This is an invalid Name"))
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
  def postcodeOrError(maybePostCode: String): Either[InvalidPostcodeError, Postcode] = {
    if (maybePostCode.trim.contains(" ")) Right(Postcode(maybePostCode))
    else Left(InvalidPostcodeError("This is an invalid postcode"))
  }
}

//  2. Create a case class called `Letter` that contains a `name` and `postcode`
//  • The `name` should have the type `Name`
//  • The `postcode` should have the type `Postcode`
case class Letter(name: Name, postcode: Postcode)


//11. Create companion object to `Letter` and inside it:
//• Create a method called `letterOrError`
//• Pass in two `String`s called `maybeName` and `maybePostCode`
//• Using a for comprehension, use the methods `nameOrError` and `postcodeOrError` to create a `Letter`.
//• Carefully consider what the return type of the `letterOrError` method should be!
object Letter {
  def letterOrError(maybeName: String, maybePostcode: String): Either [GenericPostageError, Letter] = {
    for {
      postcode <- postcodeResult
      name <- nameResult
    } yield Letter(name, postcode)
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

