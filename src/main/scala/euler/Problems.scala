package euler	

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Problem1 {
  def exec() = Future {
  	val domain = (1 to 999)
  	val range = domain filter {
  		number => number.isDivisableBy(3) || number.isDivisableBy(5)
  	}
    range.sum
  }
}

object Problem2 { 
  def exec() = Future {
  	val UpperBound = 4000000
  	val fibonacciSeries = generateFibonacciSeries(UpperBound)
  	val evenFilteredFibonacciSeries = fibonacciSeries filter(_.isEven)
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
		  val initalSeedList = List(2, 1)
		  generateFibonacciSeriesHelper(initalSeedList)
	  }
  }
}

object Problem3 {
  def exec() = Future {
  	val number = 600851475143L
  	val domain = (math.sqrt(number).toLong to 2L by -1).view
  	val range = domain filter(number.isDivisableBy(_)) filter(_.isPrime)
  	val largestPrimeFactor = range(0)
    largestPrimeFactor
  }
}

object Problem4 {
  def exec() = Future {
    val lowerBound = 100 * 100
    val upperBound = 999 * 999
    largestPalindromicNaturalNumber(lowerBound, upperBound)
  }
  
  private def largestPalindromicNaturalNumber(lowerBound: Int = 0, upperBound: Int = Integer.MAX_VALUE): Int = { 
    if (upperBound < 0) error("Upper bound must be a natural number")
    else if (upperBound < lowerBound) error("No palindromic natural number found with in given bounds")
    else if (upperBound.isPalindrome && upperBound.isMultipleOfTwoThreeDigitIntegers) upperBound
    else largestPalindromicNaturalNumber(lowerBound, upperBound - 1)
  }
}

object Problem5 {
  def exec() = Future {
  	val divisors = (1L to 20L).toStream
    RichInt.lcm(divisors: _*) match {
      case Some(value) => value
    	case _ => error("Improper range of divisors")
    }
  }
}

object Problem6 {
  def exec() = Future {
    DifferenceOfSumSquareAndSquaresSumOfNaturalNumbersTill(100)
  }

  private def DifferenceOfSumSquareAndSquaresSumOfNaturalNumbersTill(upperBound: Int) =
    (upperBound) *
    (upperBound + 1) / 2 *
    (upperBound * (upperBound + 1) / 2 - (2 * upperBound + 1) / 3)
}