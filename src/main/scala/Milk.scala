abstract class Milk

object WholeMilk extends Milk {

   override def toString() : String = s"Whole Milk"
}

object SemiSkimmedMilk extends Milk {

  override def toString() : String = s"Semi Skimmed Milk"
}

case class FrothedMilk(`type` : Milk)


