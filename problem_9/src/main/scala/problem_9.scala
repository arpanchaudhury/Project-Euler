package euler

object Main {
  def main(args: Array[String]) = println(getTripletProduct)

  def getTripletProduct: Int = {
    for (a <- 1 to 1000)
      for (b <- a + 1 to 1000) {
        val c = 1000 - (a + b)
        if (a * a + b * b == c * c && a < b && b < c) 
          return a * b * c
      }
    return 0
  }
}
