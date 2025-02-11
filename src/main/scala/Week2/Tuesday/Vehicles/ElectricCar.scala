package Week2.Tuesday.Vehicles

case class ElectricCar(override val brand: String) extends Car(brand, "Electric") with Electric {

  override val hoursToCharge: Int = 8

  val noisyToDrive: Boolean = false //specific to ElectricCar
}


// override val - WHY?
//Class -> inheriting into Case Class
//Case class will autogenerate the val field, we also have the val field being passed down with inheritance
//We need to explicitly redefine the inherited val.