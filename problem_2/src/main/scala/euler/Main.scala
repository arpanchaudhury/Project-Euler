package euler

object Main { 
  def main(args: Array[String]) {
  	val UpperBound = 4000000
  	val fibonacciSeries = generateFibonacciSeries(UpperBound)
  	val evenFilteredFibonacciSeries = fibonacciSeries filter(_.isEven)
  	(evenFilteredFibonacciSeries sum).tap("Sum of even valued terms of fibonacci series whose values do not exceed four million")
  }

  private def generateFibonacciSeries(upperBound: Int): List[Int] = {
  	def generateFibonacciSeriesHelper(seedList: List[Int]): List[Int] = {
  		val nextTerm = seedList(0) + seedList(1)
	    if (nextTerm > upperBound) seedList
	    else generateFibonacciSeriesHelper(nextTerm :: seedList)
	}

	if (upperBound < 1) List.empty
	else if (upperBound == 1) List(1)
	else {
		val initalSeedList = List(2, 1)
		generateFibonacciSeriesHelper(initalSeedList)
	}
  }
}