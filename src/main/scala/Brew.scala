case class Coffee(water: Water, groundCoffee: GroundCoffee)

class Latte(water: Water, groundCoffee: GroundCoffee, frothedMilk: FrothedMilk) extends Coffee(water, groundCoffee)

class Americano(water: Water, groundCoffee: GroundCoffee) extends Coffee(water, groundCoffee)









