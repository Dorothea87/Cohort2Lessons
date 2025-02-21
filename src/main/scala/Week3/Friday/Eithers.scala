package Week3.Friday

import java.time.LocalDate

object Eithers extends App {

  //Takes 2 different parameters - Left (error) and Right (Success)
  //tends to favour the right, if it can get to the right, it will do so (Right biased)
  //Main use - error handling


  //  def isOdd(x: Int): Either[Boolean, String] = if (x % 2 != 0) Right(s"$x is an odd number") else Left(false)
  //  println(isOdd(4)) //Left
  //  println(isOdd(5)) //Right


  //Let's make it better
  //1. Error handle using extends Exception --> custom errors but have to make sure we use val to make parameters reachable
  class NewError(val errorCode: Int, val errorMessage: String) extends Exception

  //custom error
  case object IsOddError extends NewError(400, "Input is not odd, it is even.")

  def isOdd(x: Int): Either[NewError, String] = if (x % 2 != 0) Right(s"$x is an odd number") else Left(IsOddError)

  println(isOdd(4)) //Left
  println(isOdd(5)) //Right

  //2. Error handle using Try/Catch - gives more inbuilt information

  def plusOne(x: String): Either[String, Int] = {
    try {
      Right(x.toInt + 1)
    } catch {
      case e: Exception => Left(s"failed due to: $e") //wildcard - keeps code running
    }
  }

  println(plusOne("7")) //Right
  println(plusOne("seven")) //Left


  //Eithers with for comprehension
  //Fail fast --> this means as soon as one condition hits a left, we exit the for comprehension.


  //Try to validate a User.

  case class User(username: String, password: String, dateOfBirth: LocalDate)
  //Conditions
  //1. Username must be at least 12 characters long
  //2. Password must be a mix of upper and lower case
  //3. DoB -> must be 18

  case class ValidatedUser(username: String, password: String, dateOfBirth: LocalDate) //Return Type of final method

  case object UsernameError extends NewError(400, "Username is less than 12 characters long.")

  case object PasswordError extends NewError(400, "Password is not a mix of upper and lower case.")

  case object DateOfBirthError extends NewError(400, "Not yet 18.")

  val usernameBad = User("user", "Password", LocalDate.of(1960, 6, 5))
  val validUser = User("longerusername", "Password", LocalDate.of(1960, 6, 5))
  val invalidDOB = User("longerusername", "Password", LocalDate.of(2012, 6, 5))
  val invalidPassword = User("longerusername", "password", LocalDate.of(1960, 6, 5))

  //1. Username
  def validateUsername(username: String): Either[NewError, String] = {
    if (username.length < 12) Left(UsernameError)
    else Right(username)
  }

  println("\nValidate username (bad - left): " + validateUsername(usernameBad.username))
  println("\nValidate username (success - right): " + validateUsername(validUser.username))


  //2. Password
  def validatePassword(password: String): Either[NewError, String] = {
    if (password == password.toLowerCase || password == password.toUpperCase) Left(PasswordError)
    else Right(password)
  }

  println("\nValidate password (bad - left): " + validatePassword(invalidPassword.password))
  println("\nValidate password (success - right): " + validatePassword(validUser.password))


  //3. DoB
  def validateAge(dateOfBirth: LocalDate): Either[NewError, LocalDate] = {
    if (dateOfBirth.plusYears(18).isAfter(LocalDate.now)) Left (DateOfBirthError)
    else Right(dateOfBirth)
  }

  println("\nValidate DOB (bad - left): " + validateAge(invalidDOB.dateOfBirth))
  println("\nValidate DOB (success - right): " + validateAge(validUser.dateOfBirth))

  //4. Put all the methods together and return the Validated user if they are all happy

  def validateUser(user: User): Either[NewError, ValidatedUser] = {
    for {
      storedUsername <- validateUsername(user.username) //calling method, if happy (right), store in the val called username. If left (unhappy) - exit the for comprehension
      storedPassword <- validatePassword(user.password)
      storedDateofbirth <- validateAge(user.dateOfBirth)
      validatedUser = ValidatedUser(storedUsername, storedPassword, storedDateofbirth) //make case class using the stored data from the for comprehension
    } yield validatedUser //final return type
  }
println("\nValidateUser - bad username: " + validateUser(usernameBad)) //username error
println("\nValidateUser - bad password: " + validateUser(invalidPassword)) //password error
println("\nValidateUser - bad DOB: " + validateUser(invalidDOB)) //DOB error
println("\nValidateUser - all okay: " + validateUser(validUser)) //Right - returns case class of ValidatedUser

}
