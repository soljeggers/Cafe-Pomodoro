import java.util.concurrent.Executors
import scala.concurrent.ExecutionContext
import scala.util.Random

object Cafe extends App {

  implicit def ec : ExecutionContext = ExecutionContext.fromExecutor(Executors.newCachedThreadPool())

  def froth(milk: Milk): FrothedMilk = {
    milk match {
      case wm : WholeMilk => FrothedMilk("Full Fat Froth")
      case _ => throw MilkFrothingException("Get the blue one...")
    }
  }

  def grind(coffeeBeans: CoffeeBeans): GroundCoffee = {
    coffeeBeans.typeOfBean match {
      case a if a == "Arabica beans" => println("Grinding those Arabica beans...")
        GroundCoffee("Ground Arabica")
      case b if b == "Robusta beans" => println("Grinding those Robusta beans...")
        GroundCoffee("Ground Robusta")
      case _ => throw GrindingException("Get me some real beans...")
    }
  }

  def brewCoffee(water: Water, groundCoffee: GroundCoffee): Coffee = {
    if (water
        .temperature < 40) {
      throw BrewingException("The water is too cold")
    } else {
      Coffee(water,groundCoffee)
    }
  }

  def combine(frothedMilk: Option[FrothedMilk], coffee: Coffee) : Coffee = {
    if (frothedMilk
        .isDefined) {
      new Latte(Water(coffee.water.temperature - 5), GroundCoffee("Ground Arabica"), FrothedMilk("WholeMilk"))
    } else {
      new Americano(Water(coffee.water.temperature), GroundCoffee("Ground Arabica"))
    }
  }

  val groundbeans = grind(CoffeeBeans("Arabica bean"))
  val water = Water()
  val milk = froth(Milk("WholeMilk"))

}
