import org.scalatest.{MustMatchers, WordSpec}

class CoffeeBeansSpec extends WordSpec with MustMatchers {

  "CoffeeBeans" must {

    "return 'Get me some real beans' when provided with anything but Arabica beans'" in {
      CoffeeBeans.grind("Porridge") mustEqual "Get me some real beans"
    }

    "return 'Ground coffee' when provided with Arabica beans" ignore  {
      Grind("Arabica beans") mustEqual "Ground coffee"
    }


  }
}