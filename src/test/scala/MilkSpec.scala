import org.scalatest.{MustMatchers, WordSpec}

class MilkSpec extends WordSpec with MustMatchers {

  "Milk" must {

    "throw Exception with message 'IllegalArgumentException' when provided with Semi Skimmed Milk'" in {
      val m = Intercept[IllegalArgumentException]{
        Cafe.froth("Semi Skimmed Milk")
      }
      m.getmessage mustEqual "Get the blue one..."
    }



  }

}