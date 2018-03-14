
import org.scalatest.{MustMatchers, WordSpec}

class CafeSpec extends WordSpec with MustMatchers {

  "Cafe" must {

    "return 'The water is boiled' when no temperature is specified" in {
      Cafe.heat() mustEqual "The water is boiled"
    }
  }

}
