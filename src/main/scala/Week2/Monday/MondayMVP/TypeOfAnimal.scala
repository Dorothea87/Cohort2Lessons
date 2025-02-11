package Week2.Monday.MondayMVP

import java.security.GeneralSecurityException

trait TypeOfAnimal {

}

trait Mammal extends TypeOfAnimal {
  def isMammal: Boolean = true
}

trait Bird extends TypeOfAnimal {
  def isBird: Boolean = true
}

trait Insect extends TypeOfAnimal {
  def isInsect: Boolean = true
}
