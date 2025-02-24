package Week4.Monday.MVP

import scala.annotation.tailrec

object Task1 extends App {

  //1) Start by looking up the teams that played in the 2024 Euros.
  //a) Create an object called Euro2024 that extends Enumeration. Provide all the teams who participated in the 2024 Euros.
  //b) Write a tail recursive method to print all the teams.

  object Euro2024 extends Enumeration {
    val Germany, Spain, France, England, Italy, Netherlands, Belgium, Portugal, Denmark, Sweden, Switzerland, Austria, Poland, CzechRepublic, Croatia, Turkay, Scotland, Wales, Romania, Bulgaria, Serbia, Ukraine, Norway, Iceland = Value
  }

  def printEuroTeams(euro2024: List[Any]): String = {
      @tailrec
      def printEuroTeamsRec(teams: List[Any], acc: String): String = {
        if (teams.isEmpty) acc // Empty list case
        else {
          val head = teams.head
          val tail = teams.tail
          val makeNiceToRead = if (acc.isEmpty) "" else ", " // nice formatting
          printEuroTeamsRec(tail, acc + makeNiceToRead + head.toString)
        }
      }

    printEuroTeamsRec(euro2024, "")
  }

  println(printEuroTeams(Euro2024.values.toList))

  sealed class Team(name: String)

  object Team {
    case object Germany
    case object France
    case object Croatia
    case object Bulgaria
    case object Spain
    case object Italy
  }

  val TeamList: List[Object] = List (Team.Germany, Team.Spain, Team.Italy, Team.Croatia, Team.Bulgaria, Team.France)
  println(printEuroTeams(TeamList))
}





// 1) Start by looking up the teams that played in the 2024 Euros.
// a) Create an object called Euro2024 that extends Enumeration Provide all the teams who participated in the 2024 Euros.
// b) Write a tail recursive method to print all the teams.
// object Euro2024 extends Enumeration {    val Germany, Spain, France, England, Italy, Netherlands, Belgium, Portugal, Denmark, Sweden, Switzerland, Austria, Poland, CzechRepublic, Croatia, Turkey, Scotland, Wales, Romania, Bulgaria, Serbia, Ukraine, Norway, Iceland = Value  }
//  println(Euro2024.values)
//  println(Euro2024.Turkey)
//  println(Euro2024.Bulgaria)
//  def printEuroTeams(euro2024: List[Euro2024.Value]): String = {
//  @tailrec
//  def printEuroTeamsRec(teams: List[Euro2024.Value], acc: String): String = {
//  if (teams.isEmpty) acc // Empty list case
//  else {
//  val head = teams.head
//  val tail = teams.tail
//  val makeNiceToRead = if (acc.isEmpty) "" else ", " // nice formatting
//  printEuroTeamsRec(tail, acc + makeNiceToRead + head.toString)      }    }
//  printEuroTeamsRec(euro2024, "")  }
//  println(printEuroTeams(Euro2024.values.toList))