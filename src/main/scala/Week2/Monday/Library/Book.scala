package Week2.Monday.Library

import Week2.Monday.Family.Adult

class Book (val title: String, val author:Adult) extends ReadingFormat with Genre {
 def read: String = "Keep turning those pages."
}

object Book {
  def apply(title: String, author:Adult): Book = new Book(title, author)
}
