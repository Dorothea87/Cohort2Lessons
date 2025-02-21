package Week3.Thursday.MVP

import java.time.LocalDate
import java.time.temporal.ChronoUnit

//3) A Person case class requires the fields given in the table below. Only some of them are given at the input. The others, you’ll need to calculate.
//a) Write a method called createPerson, with the return type Person. This method will accept an InputPerson case class (this will contain all Given at input = true). This method will calculate the missing fields and return a Person.
//Consider:
//- Readability.
//- Single source of responsibility (HINT: this doesn’t all need to be in one big method, the createPerson method could call another.)
//b) Create a method called horoscope. This method should accept a LocalDate and return a tuple of the star sign and their horoscope. Use pattern matching in your method.

object Task3 extends App {

  case class Person(
                     fullName: String,
                     dateOB: LocalDate,
                     occupation: Option[String],
                     lastCountryLivedIn: String,
                     dateOfDeath: Option[LocalDate],
                     age: Int,
                     starSign: String,
                     ageOfDeath: Option[Int]
                   )

  case class InputPerson(
                          fullName: String,
                          dateOB: LocalDate,
                          occupation: Option[String],
                          lastCountryLivedIn: String,
                          dateOfDeath: Option[LocalDate]
                        )

  val inputperson1: InputPerson = InputPerson("Peter Parker", LocalDate.parse("2001-08-23"), Some("Photographer"), "USA", None)


  def createPerson(inputPerson: InputPerson): Person = {
    val age = calculateAge(inputPerson.dateOB, inputPerson.dateOfDeath)
    val ageOfDeath = inputPerson.dateOfDeath.map(deathDate => calculateAge(inputPerson.dateOB, Some(deathDate)))
    val starSign = determineStarSign(inputPerson.dateOB)

      Person(
        inputPerson.fullName,
        inputPerson.dateOB,
        inputPerson.occupation,
        inputPerson.lastCountryLivedIn,
        inputPerson.dateOfDeath,
        age,
        starSign,
        ageOfDeath
      )
  }

  def calculateAge(birthDate: LocalDate, deathDate: Option[LocalDate]): Int = {
    val effectiveDeathDate = deathDate.getOrElse(LocalDate.now())
    ChronoUnit.YEARS.between(birthDate, effectiveDeathDate).toInt
  }

  def determineStarSign(date: LocalDate): String = {
    val month = date.getMonthValue
    val day = date.getDayOfMonth
    (month, day) match {
      case (1, d) if d <= 20 => "Capricorn"
      case (1, _) => "Aquarius"
      case (2, d) if d <= 18 => "Aquarius"
      case (2, _) => "Pisces"
      case (3, d) if d <= 20 => "Pisces"
      case (3, _) => "Aries"
      case (4, d) if d <= 20 => "Aries"
      case (4, _) => "Taurus"
      case (5, d) if d <= 21 => "Taurus"
      case (5, _) => "Gemini"
      case (6, d) if d <= 21 => "Gemini"
      case (6, _) => "Cancer"
      case (7, d) if d <= 22 => "Cancer"
      case (7, _) => "Leo"
      case (8, d) if d <= 23 => "Leo"
      case (8, _) => "Virgo"
      case (9, d) if d <= 22 => "Virgo"
      case (9, _) => "Libra"
      case (10, d) if d <= 23 => "Libra"
      case (10, _) => "Scorpio"
      case (11, d) if d <= 22 => "Scorpio"
      case (11, _) => "Sagittarius"
      case (12, d) if d <= 21 => "Sagittarius"
      case (12, _) => "Capricorn"
      case _ => "Unknown"
    }
  }

  println(inputperson1)
  val person1 = createPerson(inputperson1)
  println(person1)

}
