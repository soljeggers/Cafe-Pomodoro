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
      case m @ WholeMilk => FrothedMilk(m)
      case _ => throw new MilkFrothingException("Get the blue one...")
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
      Coffee(water, groundCoffee)
    }
  }

  def combine(frothedMilk: Option[FrothedMilk], coffee: Coffee): Coffee = {
    if (frothedMilk
        .isDefined) {
      new Latte(Water(coffee
                      .water
                      .temperature - 5), GroundCoffee("Ground Arabica"), frothedMilk.get)
    } else {
      new Americano(Water(coffee
                          .water
                          .temperature), GroundCoffee("Ground Arabica"))
    }
  }

  val groundbeans = grind(ArabicaBean)
  val groundbeans2 = grind(RobustaBean)
  val milk = WholeMilk
  val brewc = brewCoffee(Water(), GroundCoffee("Ground Arabica"))
}
