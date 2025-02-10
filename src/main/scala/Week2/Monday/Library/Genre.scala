package Week2.Monday.Library

import java.security.GeneralSecurityException

trait Genre {

  def enjoy: String = "Enjoy your book"

}

trait Fantasy extends Genre {
  override def enjoy: String = "Enjoy your fantasy book!"
}

trait Crime extends Genre

trait Romance extends Genre
