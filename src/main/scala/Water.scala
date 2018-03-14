case class Water(temperature: Double = 40) extends App {

  def heat(water: Water, temperature: Double): Water = {
    water
    .copy(temperature)
  }

}


