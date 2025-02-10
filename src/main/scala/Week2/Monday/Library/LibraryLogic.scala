package Week2.Monday.Library

import Week2.Monday.Family.{Adult, Forename, Surname}

object LibraryLogic extends App {
   val harryPotter: Book = new Book("Harry Potter", Adult(new Forename(("J.K.")), new Surname("Rowling"))) with Fantasy with Audiobook with PhysicalBook with DigitalBook

  println(harryPotter.author.forename.forename)
  println(harryPotter.title)
  println(harryPotter.read)
  println(harryPotter.enjoy)

  val deathOnTheNile: Book = new Book("Death on the Nile", Adult(new Forename(("Agatha")), new Surname("Christie"))) with Crime
  println(deathOnTheNile.enjoy)
}
