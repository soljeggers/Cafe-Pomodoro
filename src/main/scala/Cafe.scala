case class GroundCoffee(typeOfCoffee: String)

object Cafe extends App {

  def grind(typeOfBean: String) : GroundCoffee = {
    typeOfBean match {
      case a if a == "Arabica beans" => GroundCoffee("Ground Arabica")
      case b if b == "Robusta beans" => GroundCoffee("Ground Robusta")
      case _ => throw new IllegalArgumentException("Get me some real beans...")
    }
  }

}
