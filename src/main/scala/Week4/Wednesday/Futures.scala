package Week4.Wednesday

import Week3.Friday.Eithers.{NewError, isOdd}

import java.util.concurrent.TimeUnit
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.{Duration, FiniteDuration}
import scala.util.{Failure, Random, Success}

object Futures extends App {

  //What are Futures?
  //These represent values that are not yet ready - but they will be in the future.

  //Why do we use them?
  //If we didn't use them sometimes our programme would pause and wait for long operations to be finished (for example fetching data from a DB or an API).
  //The Future allows us to run tasks in the background like fetching our data, without stopping the whole programme.

  //How do we create them?
  val futureHelloWorld: Future[String] = Future {
    Thread.sleep(2000) //Pausing the thread for 2 seconds
    "Hello Future World!"
  }
  //How can we print these Futures?

  //NOT LIKE THIS
  println("Standard print line: " + futureHelloWorld) //This is printing the future itself, rather than the value

  //1st way - use built-in methods like .foreach as a callback
  futureHelloWorld.foreach(result => println(s"Using .foreach: $result"))

  //2nd way - use onComplete(use this when we want to handle successes and failures)
  futureHelloWorld.onComplete {
    case Success(result) => println(s"Using .oncomplete: $result")
    case Failure(exception) => println(s"Failure with .onComplete: ${exception.getMessage}")
  }

  //3rd way - using Await.result
  val waitTime: FiniteDuration = Duration(5, TimeUnit.SECONDS) //Wait 5 seconds, if you don't receive the value within the 5 seconds proceed to time out
  //THIS WILL BLOCK THE THREAD (and therefore future cannot be used in parallel)
  //only use when essential
  println("Using await: " + Await.result(futureHelloWorld, waitTime)) //collect the information, then print it after you have waited for the time stated in waitTime

  println("I am printed after the futures are called") //Proving that with .foreach and .onComplete this is printed before, so it is happening while we wait for the future to be returned


  def futureAddition(x: Int, y: Int): Future[Int] = Future {
    Thread.sleep(2000)
    x + y
  }

  futureAddition(4, 5).foreach(result => println(s"With foreach: $result"))
  futureAddition(4, 6).onComplete {
    case Success(result) => println(s"With onComplete: $result")
    case Failure(exception) => println(s"Failure onComplete: ${exception.getMessage}")
  }

  def fetchIsOddOrErrorInTheFuture(num: Int): Future[Either[NewError, String]] = Future {
    Thread.sleep(1000)
    isOdd(num)
  }

  //Why a val? Because the method it is calling already is a future and I don't need to make a new one
  val eventuallyIsOddOrError: Future[Either[NewError, String]] = fetchIsOddOrErrorInTheFuture(6)

  Thread.sleep(1100) //This will force the thread to sleep before i gets to the .value in the pattern match which forces it to get the future immediately.

  //This function only cares about deciding if the future completed or not. It will not get us out of the Either. If it completes and  receives either the Left or the Right, it will be a Success. If the future did not complete due to a time out, it will hit the None. This is better than the code crashing.
  //What is .value? It checks the value immediately before the future has had time to complete
  val result = eventuallyIsOddOrError.value match {
    case Some(Success(complete)) => s"Future completed: $complete"
    case None => "Future did not complete in the given time"
  }

  println("isOddOrError" + result)

  //Combine futures?
  //We do this when we want multiple tasks done at once
  //Not going to force them to sleep, this means they will run asynchronously, which is in parallel on separate threads.

  val futureInt1: Future[Int] = Future {
    100
  }

  val futureInt2: Future[Int] = Future {
    8
  }

  val combinedFutureInt = for { //for comp will wait for all results to be back before the final result
    number1 <- futureInt1
    number2 <- futureInt2
  } yield number1 + number2

  println(Await.result(combinedFutureInt, waitTime))

  //TASK 1
  val futureHello: Future[String] = Future {
    "Hello"
  }

  val futureWorld: Future[String] = Future {
    "World"
  }

  val combinedFutureHelloWorld = for {
    word1 <- futureHello
    word2 <- futureWorld
  } yield word1 + " " + word2

  println(Await.result(combinedFutureHelloWorld, waitTime))

  //TASK 2
  val futureName: Future[String] = Future {
    val randomDelay = Random.nextInt(200) + 1000
    Thread.sleep(randomDelay)
    "User: Alice"
  }

  val futureOrder: Future[String] = Future {
    val randomDelay = Random.nextInt(200) + 1000
    Thread.sleep(randomDelay)
    if (randomDelay < 2000) "Order: Salad" else "Order: Pizza"
  }

  val combinedFutureOrder = for {
    name1 <- futureName
    order1 <- futureOrder
  } yield name1 + " " + order1


 combinedFutureOrder.foreach(println)



  Thread.sleep(3000) //This ensures the object thread does not finish before the future has completed.

}
