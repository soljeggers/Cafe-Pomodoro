case class Water(temperature: Double = 40) {

  def heat(temperature: Double): Water = {
    this.copy(temperature)
  }

}


