case class GroundCoffee()

case class CoffeeBeans(typeOfProduce: String) {

  def grind(): GroundCoffee =  {
this.typeOfProduce match {
  case _ => "Get me some real beans"
}


  }
}


//  case "Arabica Beans" => GroundCoffee
