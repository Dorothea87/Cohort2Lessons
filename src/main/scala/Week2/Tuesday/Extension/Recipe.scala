package Week2.Tuesday.Extension
/**1. Construct a case class that takes in a minimum of 3 parameters, each of a different type, and a case object.
 2. Create 3 instances of the case class.
 3. Use the “.copy” method to create a further 3 instances, each time modifying a different class parameter.
 4. Use the “.toString” method to print all parameters of the instance you have already created for exercise 3.
 5. Use the “.equals” method to compare case class instances you have already created as part of the exercises so far. */

object CaseClassesExtension extends App {

  case class Recipe(name: String, portions: Int, ingredients: List[String], seasoning: Seasoning)

  val carbonara = Recipe.apply("Spaghetti Carbonara", 4, List("500g Spaghetti", "2 eggs", "100g Parmesan cheese", "200g pancetta"))
  val dauphinoise = Recipe.apply("Dauphinoise", 6, List("500g potatoes", "2 eggs", "100g Comte cheese", "200ml double cream", "1 shallot"))
  val bananaBread = Recipe.apply("Banana Bread", 8, List("3 large bananas", "3 eggs", "150g sugar", "150g butter", "150g soft white flour", "1.5 tsp baking powder"))

  println(bananaBread)
  println(bananaBread.name)

  //case object NoRecipe extends Recipe("No name", 0, List())
  sealed trait Seasoning
  case object Salt extends Seasoning
  case object Pepper extends Seasoning
  case object Nutmeg extends Seasoning
  case object Cinnamon extends Seasoning

  //val copiedSpiderMan = spiderMan.copy(weakness = "Spider Slayer Squad")
  val copiedCarbonara1 = carbonara.copy(portions = 6)
  val copiedCarbonara2 = carbonara.copy(name = "Penne Carbonara")
  val copiedCarbonara3 = carbonara.copy(ingredients = List("600g Spaghetti", "3 eggs", "150g Parmesan cheese", "300g pancetta"))

  println(copiedCarbonara3.toString)

  val stringCarbonara = carbonara.toString
  println(s"Here is a recipe for Spaghetti Carbonara: $stringCarbonara")

  val areEqual = carbonara.equals(copiedCarbonara3)
  println(s"Are the recipes equal? $areEqual")
}