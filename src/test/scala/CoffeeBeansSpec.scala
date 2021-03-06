
import org.scalatest.{MustMatchers, WordSpec}

class CoffeeBeansSpec extends WordSpec with MustMatchers {

  object InvalidBean extends CoffeeBeans

  "CoffeeBeans" must {

    "throw Exception with message 'Get me some real beans...' when provided with anything but 'Arabica beans' or 'Robusta beans'" in {

      val x = intercept[GrindingException] {
        Cafe.grind(InvalidBean)
      }
      x.getMessage mustEqual "Get me some real beans..."
    }

    "return 'Ground Arabica' when provided with 'Arabica beans' " in  {
      Cafe.grind(ArabicaBean) mustEqual GroundCoffee("Ground Arabica")
    }

    "return 'Ground Robusta' when provided with 'Robusta beans'" in {
      Cafe.grind(RobustaBean) mustEqual GroundCoffee("Ground Robusta")
    }
  }
}