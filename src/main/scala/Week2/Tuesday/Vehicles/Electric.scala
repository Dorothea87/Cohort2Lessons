package Week2.Tuesday.Vehicles

trait Electric {
  val hoursToCharge: Int //abstract field - must declare it at sub class method (as soon as I extend)
  def charge: String = s"Charge me for $hoursToCharge hours. "

}
