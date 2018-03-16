case class GroundCoffee(typeOfCoffee: String)

case class FrothedMilk(typeOfFroth: String)

case class BeanGrindException(msg: String) extends Exception


object Cafe extends App {

  def froth(typeOfMilk: String) : FrothedMilk = {
    typeOfMilk match {
      case sm if sm == "Semi Skimmed Milk" => throw new IllegalArgumentException("Get the blue one...")
      case wm => FrothedMilk("Full Fat Froth")
    }
  }


  def grind(typeOfBean: String): GroundCoffee = {
    typeOfBean match {
      case a if a == "Arabica beans" => GroundCoffee("Ground Arabica")
      case b if b == "Robusta beans" => GroundCoffee("Ground Robusta")
      case _ => throw new IllegalArgumentException("Get me some real beans...")
    }
  }
}
