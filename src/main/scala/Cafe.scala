import java.util.concurrent.Executors
import scala.concurrent.ExecutionContext
import scala.util.Random

class MilkFrothingException(msg : String) extends Exception(msg)
class BrewingException(msg : String) extends Exception(msg)
class GrindingException(msg : String) extends Exception(msg)

object Cafe extends App {

  implicit def ec: ExecutionContext = ExecutionContext
                                      .fromExecutor(Executors
                                                    .newCachedThreadPool())

  def froth(milk: Milk): FrothedMilk = {
    milk match {
      case m @ WholeMilk =>
        println(s"Adding the Full Fat $milk Froth")
        FrothedMilk(m)
      case _ => throw new MilkFrothingException("You can't froth Semi skimmed milk, Get the blue one...")
    }
  }

  def grind(coffeeBeans: CoffeeBeans): GroundCoffee = {
    coffeeBeans match {
      case ab @ ArabicaBean =>
        println("Grinding those Arabica beans...")
        GroundCoffee("Ground Arabica")
      case rb @ RobustaBean =>
        println("Grinding those Robusta beans...")
        GroundCoffee("Ground Robusta")
      case _ => throw new GrindingException("Get me some real beans...")
    }
  }

  def brewCoffee(water: Water, groundCoffee: GroundCoffee): Coffee = {
    if (water
        .temperature < 40) {
      throw new BrewingException("The water is too cold")
    } else {
      println(s"Heating the water to ${water.temperature} and adding the $groundCoffee")
      Coffee(water, groundCoffee)
    }
  }

  def combine(frothedMilk: Option[FrothedMilk], coffee: Coffee): Coffee = {
    if (frothedMilk
        .isDefined) {
      println("YOU'VE MADE A LATTE LAD! GOOD JOB!")
      new Latte(Water(coffee
                      .water
                      .temperature - 5), GroundCoffee("Ground Arabica"), frothedMilk.get)

    } else {
      println("OOOO NO MILK... I GUESS THIS IS AN AMERICANO?!")
      new Americano(Water(coffee
                          .water
                          .temperature), GroundCoffee("Ground Arabica"))
    }
  }

  val groundbeans = grind(ArabicaBean)
  val milk = froth(WholeMilk)
  val waterTemp = Water(50)
  val brewc = brewCoffee(Water(), GroundCoffee("Ground Arabica"))
  val makeLatte = combine(Some(milk), brewc)


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
