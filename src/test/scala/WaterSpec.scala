import org.scalatest.{MustMatchers, WordSpec}

class WaterSpec extends WordSpec with MustMatchers {

  "Water" must {

    "return 'The water is boiled' when no temperature is specified" in {

      Cafe.water mustEqual "The Water is boiled..."

    }
  }
}
