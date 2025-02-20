package Week3.Thursday

object PatternMatching extends App {

  val weather: String = "Cold"

  if (weather.toLowerCase == "cold") {
    println(s"It is $weather! Take a coat.")
  } else if (weather.toLowerCase == "raining") {
    println(s"It is $weather! Take an umbrella.")
  } else {
    println(s"$weather is not valid")
  }

  weather.toLowerCase match {
    case "cold" => println(s"It is $weather! Take a coat.")
    case "raining" => println(s"It is $weather! Take an umbrella.")
    case _ => println(s"$weather is not valid") //Wildcard - this will catch anything else
  }


  val numOfWatermelons: Int = 7
  numOfWatermelons match  {
    case 1 | 2 | 3 => println("He can carry them without a bag")
    case 4 | 5 => println("He needs to bring a bag")
    case x => println(s"$x is invalid") //if you want to use interpolation with an Int, need to assign it to x rather than _
  }

  abstract class Notification //Have to extend it - can't instantiate
  case class Email (sender: String, title: String, body: String) extends Notification
  case class Text (sender: String, body: String) extends Notification
  case class VoiceNote (sender: String, lengthOfBody: Int) extends Notification

  val notification: Notification = Text("Mum", "Where are you?")

  notification match {
    case Email(sender, title, body) => println("Email from " + sender)
    case Text(sender, body) if sender == "Mum" => println("Text from " + sender + ". Message: " + body)
    case Text(sender, body) => println("Text from " + sender)
    case VoiceNote(sender, lengthOfBody) => println("Voice note from " + sender + " Length: " + lengthOfBody)
  }




}
