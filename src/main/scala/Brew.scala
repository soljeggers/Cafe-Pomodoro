case class Coffee(water: Water, groundCoffee: GroundCoffee) {
}

case class BrewingException(msg : String) extends Exception(msg)


case class Latte(milk:FrothedMilk, coffee: Coffee)






