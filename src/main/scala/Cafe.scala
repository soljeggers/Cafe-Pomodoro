import java.util.concurrent.Executors
import scala.concurrent.{ExecutionContext, Future}
import scala.util.control.NonFatal
import scala.util.{Failure, Random, Success}

class MilkFrothingException(msg : String) extends Exception(msg)
class BrewingException(msg : String) extends Exception(msg)
class GrindingException(msg : String) extends Exception(msg)

object Cafe extends App {

  implicit def ec: ExecutionContext = ExecutionContext
                                      .fromExecutor(Executors
                                                    .newCachedThreadPool())

  def froth(milk: Milk): Future[FrothedMilk] = Future {
    println("Got milk? yeah buddy I'll froth that for you")
    Thread
    .sleep(Random
           .nextInt(2000))
    milk match {
      case m @ WholeMilk =>
        println(s"Adding the Full Fat $milk Froth")
        FrothedMilk(m)
      case _ => throw new MilkFrothingException("You can't froth Semi skimmed milk, Get the blue one...")
    }
  }

  def grind(coffeeBeans: CoffeeBeans): Future[GroundCoffee] = Future {
    println(s"Starting to grind the $coffeeBeans")
    Thread
    .sleep(Random
           .nextInt(200))
    coffeeBeans match {
      case ab @ ArabicaBean =>
        println("oooooo Arabica powder has been created...")
        GroundCoffee("Ground Arabica")
      case rb @ RobustaBean =>
        println("ooooooooo Robusta powder has been created...")
        GroundCoffee("Ground Robusta")
      case _ => throw new GrindingException("Get me some real beans...")
    }
  }

  def brewCoffee(water: Water, groundCoffee: GroundCoffee): Future[Espresso] = Future {
    Thread
    .sleep(Random
           .nextInt(400))
    if (water
        .temperature < 40) {
      throw new BrewingException("The water is too cold")
    } else {
      println(s"You're $groundCoffee has been tamped, now brewing your Espresso at ${water.temperature} degrees")
      Espresso(water, groundCoffee)
    }
  }

  def combine(frothedMilk: Future[FrothedMilk], coffee: Espresso): Unit = {
    Thread
    .sleep(Random
           .nextInt(2000))
    frothedMilk
    .onComplete {
      case Success(m) => new Latte(Water(), GroundCoffee("Ground Arabica"), FrothedMilk(WholeMilk))
        println("Congrats on the Latte G")
      case Failure(e) => Espresso(Water(), GroundCoffee("Ground Arabica"))
//      case Failure(NonFatal(nf)) => throw new MilkFrothingException("That ain't right G")
    }
  }
  val groundbeans = grind(ArabicaBean)
  val milk = froth(WholeMilk)
  val waterTemp = Water(50)
  val brewc = brewCoffee(Water(), GroundCoffee("Ground Arabica"))

//  val makeLatte = combine(milk, brewc(Water(), GroundCoffee("")))


//  val makeCoffee =  {
//    for {
//      ground <- groundbeans
//      milky <- milk
//      espresso <- brewc
//    } yield {
//      combine(Some(milk), espresso)
//    }                              
//  }
}
