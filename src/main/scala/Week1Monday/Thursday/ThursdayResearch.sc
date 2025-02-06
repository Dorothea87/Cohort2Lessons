//1. What makes a Set different from a Seq? What should Set(1,2) == Set(2,1,1,1) return?

/** What is a SET?
 * Sets are Iterables that contain no duplicate elements. -> Scala docs
 * Scala Set is a collection of pairwise different elements of the same type. In other words, a Set is a collection that contains no duplicate elements. There are two kinds of Sets, the immutable and the mutable. The difference between mutable and immutable objects is that when an object is immutable, the object itself can't be changed.
 * https://www.tutorialspoint.com/scala/scala_sets.htm#:~:text=Scala%20Set%20is%20a%20collection,the%20immutable%20and%20the%20mutable.
 */
//It will return a Boolean which is true because Scala ignores the duplicates, since they are not allowed and just keeps the unique elements
Set(1,2) == Set(2,1,1,1)

//2. What do you think List(3,4) == Seq(3,4) will return? Why?
//Prediction: It will return a Boolean, it should be true
//Explanation: they are both collections which represent sequences of elements. The machine compares the elements and checks if they are in the same order, which are identical here. (equality of content and order)
List(3,4) == Seq(3,4)

//3. What about List(5,6) == Set(5,6)?
//Prediction: It will return a Boolean, it will be false
//Explanation: A Set is a different type of Iterable/Collection from a Seq (and therefor also a List) and they behave differently. A set is an unordered collection and treats 5 and 6 as unique elements whereas in a List the order of elements is important and maintains the order of its elements (that's why we can use indices to find elements)

List(5,6) == Set(5,6)