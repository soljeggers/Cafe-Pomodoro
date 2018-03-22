abstract class CoffeeBeans

object ArabicaBean extends CoffeeBeans {

  override def toString() : String = s"Arabica beans"
}

object RobustaBean extends CoffeeBeans {

  override def toString() : String = s"Robusta beans"
}

case class GroundCoffee(`type`: String)





