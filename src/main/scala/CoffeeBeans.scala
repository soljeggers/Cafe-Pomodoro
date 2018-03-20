case class CoffeeBeans(typeOfBean: String)

class ArabicaBean(typeOfBean:String) extends CoffeeBeans(typeOfBean)

class RobustaBean(typeOfBean:String) extends CoffeeBeans(typeOfBean)

case class GroundCoffee(typeOfCoffee: String)

case class GrindingException(msg : String) extends Exception(msg)





