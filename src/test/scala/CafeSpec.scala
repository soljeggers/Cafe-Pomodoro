import org.scalatest.{MustMatchers, WordSpec}

class CafeSpec extends WordSpec with MustMatchers {

  "Cafe" must {

    "return a Latte with type of milk when coffee and milk are combined together" in {

      Cafe.combine(FrothedMilk("WholeMilk"), Coffee(Water(40), GroundCoffee("")) mustEqual Latte(FrothedMilk("WholeMilk"), Coffee(Water(35), GroundCoffee(""))))
    }
  }

}