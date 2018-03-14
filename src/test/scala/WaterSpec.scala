import org.scalatest.{MustMatchers, WordSpec}

class WaterSpec extends WordSpec with MustMatchers {

  "Water" must {

     "Boil to 40 degrees, if no temperature is specified" in {
      Water() mustEqual Water(40)

    }

    "return a new instance of Water with specified temperature" in {
      Water(90) mustEqual Water(90)

    }
  }
}
