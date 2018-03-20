import org.scalatest.{MustMatchers, WordSpec}

class MilkSpec extends WordSpec with MustMatchers {

  "Milk" must {

    "throw Exception with message 'IllegalArgumentException' when provided with Semi Skimmed Milk'" in {
      val m = intercept[MilkFrothingException] {
       Cafe.froth( SemiSkimmedMilk)
      }
      m.getMessage mustEqual "Get the blue one..."
    }

    "return FrothedMilk when using Whole Milk" in {
      Cafe.froth(WholeMilk) mustEqual FrothedMilk(WholeMilk)
    }
  }
}