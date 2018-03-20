case class Milk(typeOfMilk: String)

class WholeMilk(typeOfMilk: String) extends Milk(typeOfMilk)

class SemiSkimmedMilk(typeOfMilk: String) extends Milk(typeOfMilk)

case class FrothedMilk(typeOfFroth: String)

case class MilkFrothingException(msg : String) extends Exception(msg)

