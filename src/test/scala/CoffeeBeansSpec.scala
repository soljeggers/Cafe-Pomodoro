import org.scalatest.{MustMatchers, WordSpec}

class CoffeeBeansSpec extends WordSpec with MustMatchers {

  "CoffeeBeans" must {

    "throw Exception with message 'Get me some real beans...' when provided with anything but 'Arabica beans'" in {

      val x = intercept[IllegalArgumentException] {
        Cafe.grind("Porridge")
      }
      x.getMessage mustEqual "Get me some real beans..."
    }

    "return 'Ground Arabica' when provided with 'Arabica beans' " in  {
      Cafe.grind("Arabica beans") mustEqual GroundCoffee("Ground Arabica")
    }

    "return 'Ground Robusta' when provided with 'Robusta beans'" in {
      Cafe.grind("Robusta beans") mustEqual GroundCoffee("Ground Robusta")
    }

  }
}