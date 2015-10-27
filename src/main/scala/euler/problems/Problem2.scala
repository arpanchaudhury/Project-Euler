package euler.problems

import euler._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Problem2 {
  def exec() = Future {
    val UpperBound = 4000000
    val fibonacciSeries = generateFibonacciSeries(UpperBound)
    val evenFilteredFibonacciSeries = fibonacciSeries filter (_.isEven)
    evenFilteredFibonacciSeries sum
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
      val initialSeedList = List(2, 1)
      generateFibonacciSeriesHelper(initialSeedList)
    }
  }
}
