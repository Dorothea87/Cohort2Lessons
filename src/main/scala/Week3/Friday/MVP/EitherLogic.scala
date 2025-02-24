package Week3.Friday.MVP

object EitherLogic extends App{
//6. Create an object called EitherLogic and extend App to make it runnable. Inside the object,
  //create the following values that have a type `Either [GenericPostageError, Letter]`
  //• `val letter`: A letter constructed using the `.apply` method of `Letter`
  //• `val invalidLetter`: An error constructed using the `.apply` method of `InvalidNameError`
  //val letter: Either[GenericPostageError, Letter] = Right(Letter()),

  //7. Now, since you defined a value, you can actually refine the above values to be:
  //• `val letter: Right [Nothing, Letter]`
  //• `val invalidLetter: Left [InvalidNameError, Nothing]`
  //• These are still valid types!

val letter: Right[Nothing, Letter] = Right(Letter(Name("Dorothea"), Postcode("SW18 2NX")))
  val invalidLetter: Left[InvalidNameError, Nothing] = Left(InvalidNameError("The name is invalid"))

  val validName = Name.nameOrError("Peter")
  val invalidName = Name.nameOrError("Peter123")

  val validPostcode = Postcode.postcodeOrError("SW18 2NX")
  val invalidPostcode = Postcode.postcodeOrError("SW182NX")


  //8. Print the values above, can you see if it's a `Right` or `Left`?
  println(letter)
  println(invalidLetter)
  println(invalidName)
  println(validName)
  println(invalidPostcode)
  println(validPostcode)

  //12. Create the following variables inside the EitherLogic Object, using the `.letterOrError` method
  //you created in Q11.
  //• `val letterWithANumberInName`: A letter constructed with a number in the name
  //• `val letterWithAnInvalidPostcode`: A letter constructed with an invalid postcode
  //• `val letterAllInvalid`: A letter constructed with a number in the name and an invalid
  //postcode
  //• `val letterAllValid`: A letter constructed with a valid name and an valid postcode

  val letterWithANumberInName
  //13. Print the values above, are the error messages and types what you expected? Which error
  //was printed out for `val letterAllInvalid`? Why?
}
