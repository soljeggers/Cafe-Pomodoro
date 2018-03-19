case class FrothedMilk(typeOfFroth: String)

case class BeanGrindException(msg: String) extends Exception

object Cafe extends App {

  def froth(milk: Milk): FrothedMilk = {
    milk match {
      case wm : WholeMilk => FrothedMilk("Full Fat Froth")
      case _ => throw new IllegalArgumentException("Get the blue one...")

    }
  }

  def grind(coffeeBeans: CoffeeBeans): GroundCoffee = {
    coffeeBeans.typeOfBean match {
      case a if a == "Arabica beans" => GroundCoffee("Ground Arabica")
      case b if b == "Robusta beans" => GroundCoffee("Ground Robusta")
      case _ => throw new IllegalArgumentException("Get me some real beans...")
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


  val groundbeans = grind(CoffeeBeans("Arabica bean"))
  val water = Water()
  val milk = froth(Milk("WholeMilk"))
  
  def combine(frothedMilk: FrothedMilk, coffee: Coffee) : Latte = Latte(frothedMilk, coffee)

}
