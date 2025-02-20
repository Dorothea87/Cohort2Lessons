package Week3.Thursday

import Week3.Thursday.Options.Pizza

object OptionsTask extends App {

  trait ChocolateBar {
    val filling: Option[String]
  }

  object SaltedCaramel extends ChocolateBar {
    override val filling: Option[String] = Some("salted caramel")
  }

  object Snickers extends ChocolateBar {
    override val filling: Option[String] = Some("peanuts")
  }

  object MysteryBar extends ChocolateBar {
    override val filling: Option[String] = None
  }


  val newChocolateBar: ChocolateBar = new ChocolateBar {
    override val filling: Option[String] = Some("peanut")
  }
}
