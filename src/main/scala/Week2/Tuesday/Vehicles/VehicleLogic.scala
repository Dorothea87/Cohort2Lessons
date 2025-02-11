package Week2.Tuesday.Vehicles

object VehicleLogic extends App{

  println("\n-----Car-----\n")

  //car is a class so far without companion object hence using new keyword
  val ford = new Car("Ford", "Petrol")
  println(ford.fuelType) //coming from Car
  println(ford.drive) //comes from Vehicle, override in Car
  println(ford.brand) //comes from Vehicle
  println(ford.description) //comes from Vehicle, not overriden in Car

  println("\n-----ElectricCar-----\n")

  val electricFord = ElectricCar("Ford") // new ElectricCar object
  println(electricFord.fuelType)
  println(electricFord.drive)
  println(electricFord.brand)
  println(electricFord.description)
  println(electricFord.noisyToDrive) //coming from ElectricCar
  println(electricFord.hoursToCharge) //coming from Electric Trait
  println(electricFord.charge) //coming from Electric Trait

}
