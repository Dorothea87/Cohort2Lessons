/** 1. We discussed “.copy”, “.toString” and “.equals” methods but there are a lot more
 available, such as “.getClass”, “canEqual” etc. Find as many as you can, what do they
 do? Try to apply them the case classes you’ve created.
 2. Is there difference between “.equals” and “.==” methods and why? */

//-> they are available to each object because they inherit from the Any class.
//-> we can also apply them to case classes (some of them like .equals, .hashCode, .toString), use them based on the class parameters, very useful for creating data models
//-> any is the root of the Scala class hierarchy: https://www.scala-lang.org/api/current/scala/Any.html

//.equals(other: Any) checks if two objects are the same based on their content -> can be overriden in custom classes to define specific equality logic
//"==" calls the .equals method, it also automatically handles null comparison (with no parameters given)