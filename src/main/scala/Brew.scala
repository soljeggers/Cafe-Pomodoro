case class Coffee(water: Water, groundCoffee: GroundCoffee) {
}

case class BrewingException(msg : String) extends Exception(msg)


class Latte(water: Water, groundCoffee: GroundCoffee, frothedMilk: FrothedMilk) extends Coffee(water, groundCoffee)

class Americano(water: Water, groundCoffee: GroundCoffee) extends Coffee(water, groundCoffee)







