import org.scalatest.{MustMatchers, WordSpec}

class BrewSpec extends WordSpec with MustMatchers {

  "Brew" must{

    "throw BrewingException with message 'The water is too cold' when water is less that 40 degrees" in {
      val br = intercept[BrewingException] {
        Cafe.brewCoffee(Water(0), GroundCoffee(""))
      }
      br.getMessage mustEqual "The water is too cold"
    }

    "return a Coffee when Water and GroundCoffee are brewed at a temperature of 40 degrees or above" in{
      Cafe.brewCoffee(Water(40), GroundCoffee("")) mustEqual Espresso(Water(40),GroundCoffee(""))
    }
  }

}
