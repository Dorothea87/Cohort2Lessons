/**1. Write a function to interact with the terminal. If you enter the word ”Hello”, have the
 command line return “Hello X”, where X is a given name.
 2. Expand on your basic terminal interaction from above. Have a small conversation given
 specific inputs (this can be about anything you like; weather, films, sports…) */
package Week1Monday.Friday

import scala.io.StdIn.readLine

object FridayExtension extends App {

  println("Please enter your Name:")
  val name = readLine()
    println("Now say hello:")
  val hello = readLine()
    println(s"Hello $name")
  println("how is the weather? (choose from rainy, sunny, cloudy)")
  val weather = readLine()
  if (weather == "rainy") {
    println("I am sorry, that's pretty sad for a weekend :(")
  } else if (weather == "sunny") {
    println("What are you doing in front of your computer? Get out there and enjoy it while it lasts!")
  } else if (weather == "cloudy") {
    println("Could be worse, at least it's not raining and you don't get a sunburn.")
  } else {
    println("This is not a valid entry, try again!")
  }
}

//https://docs.scala-lang.org/overviews/scala-book/command-line-io.html

