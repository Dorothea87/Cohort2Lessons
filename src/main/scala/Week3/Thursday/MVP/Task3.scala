package Week3.Thursday.MVP

import java.time.LocalDate

//3) A Person case class requires the fields given in the table below. Only some of them are given at the input. The others, you’ll need to calculate.
//a) Write a method called createPerson, with the return type Person. This method will accept an InputPerson case class (this will contain all Given at input = true). This method will calculate the missing fields and return a Person.
//Consider:
//- Readability.
//- Single source of responsibility (HINT: this doesn’t all need to be in one big method, the createPerson method could call another.)
//b) Create a method called horoscope. This method should accept a LocalDate and return a tuple of the star sign and their horoscope. Use pattern matching in your method.

object Task3 extends App {

  case class Person (
                    fullName: String,
                    dateOB: LocalDate,
                    occupation: Option[String],
                    lastCountryLivedIn: String,
                    dateOfDeath: Option[LocalDate],
                    age: Int,
                    starSign: String,
                    ageOfDeath: Option[Int]
                    )
  case class InputPerson (
                           fullName: String,
                           dateOB: LocalDate,
                           occupation: Option[String],
                           lastCountryLivedIn: String,
                           dateOfDeath: Option[LocalDate]
                         )
  val inputperson1: InputPerson = InputPerson("Peter Parker", LocalDate.parse("2001-08-23"), Some("Photographer"), "USA", None)

  def createPerson(inputPerson: InputPerson): Person = ???

}
