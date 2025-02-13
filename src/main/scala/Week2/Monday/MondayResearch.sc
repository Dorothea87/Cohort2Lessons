/** Research:
 • What’s the difference between an abstract class and a trait? Why might you use one over
 the other?
 In Scala, an abstract class is constructed using the abstract keyword.
 It contains both abstract and non-abstract methods and cannot support multiple inheritances
  It can't extend another class (only case classes and normal classes can) and we are not allowed to add an abstract class to an object instance

Traits support multiple inheritances, we can group things together and access it from various classes
We can add a trait to an object instance
traits do not contain parameters/constructor parameters

=> both can override in subclasses */

//Inheritance: A class can only extend one abstract class, but can mix in multiple traits (use multiple traits in a single class)
//Constructor Parameter: Abstract classes can have constructor parameters, traits cannot. Traits are used to define common functionality without additional state/information
//Initialisation: Abstract classes can have body and can define a constructor. Traits are usually used to define interfaces or functionalities without maintaining a state(keep track of an object over time (e.g. bank account which changes)

//Multiple Inheritance (use in more than one class):
    //-> use TRAITS: if you need to access functionality from multiple sources, traits allow for mixing in multiple traits into a single class (greater flexibility)

//State and Behaviour
    //-> use ABSTRACT CLASS: if you need to define common state (top level) like variables and methods, allows for constructor parameters

//Interface Definition
    //-> use TRAITS: good for default implementation or no implementation at all

//Extensibility
    //-> use TRAITS: traits can be extended and can provide default implementations that can be overriden, useful for flexibly extending functionality

//Initialisation
    //-> use ABSTRACT CLASS: for logic that must run, when the class is constructed (can include constructor parameters and initialisation code)