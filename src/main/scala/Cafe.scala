case class GroundCoffee(typeOfCoffee: String)

case class FrothedMilk(typeOfFroth: String)

case class BeanGrindException(msg: String) extends Exception

object Cafe extends App {

  def grind(typeOfBean: String) : GroundCoffee = {
    typeOfBean match {
      case a if a == "Arabica beans" => GroundCoffee("Ground Arabica")
      case b if b == "Robusta beans" => GroundCoffee("Ground Robusta")
      case _ => throw new IllegalArgumentException("Get me some real beans...")


    }
def froth(milk: Milk) : FrothedMilk = {
  typeOfMilk match{
    case c if c != "Whole Milk" => throw new IllegalArgumentException("Get the blue one...")
  }
}
  }
}
