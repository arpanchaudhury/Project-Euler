package euler	

object Problem1 {
  def exec() {
  	val domain = (1 to 999)
  	val range = domain filter {
  		number => number.isDivisableBy(3) || number.isDivisableBy(5)
  	}
  	range.sum.tap("Sum of all numbers divisable by 3 and 5 between 1 to 999 is")
  }
}

object Problem2 { 
  def exec() {
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

object Problem3 {
  def exec() {
  	val number = 600851475143L
  	val domain = (math.sqrt(number).toLong to 2L by -1).view
  	val range = domain filter(number.isDivisableBy(_)) filter(_.isPrime)
  	val largestPrimeFactor = range(0)
    largestPrimeFactor.tap("Largest prime factor of the number 600851475143")
  }
}

object Problem4 {
  def exec() {
    val lowerBound = 100 * 100
    val upperBound = 999 * 999
    largestPalindromicNaturalNumber(lowerBound, upperBound).tap("Largest palindrome made from the product of two 3-digit numbers") 
  }
  
  private def largestPalindromicNaturalNumber(lowerBound: Int = 0, upperBound: Int = Integer.MAX_VALUE): Int = { 
    if (upperBound < 0) error("Upper bound must be a natural number")
    else if (upperBound < lowerBound) error("No palindromic natural number found with in given bounds")
    else if (upperBound.isPalindrome && upperBound.isMultipleOfTwoThreeDigitIntegers) upperBound
    else largestPalindromicNaturalNumber(lowerBound, upperBound - 1)
  }
}

object Problem5 {
	def exec() {
		val divisors = (1L to 20L).toStream
	  	RichInteger.lcm(divisors: _*) match {
	  		case Some(value) => value.tap("Smallest positive number that is evenly divisible by all of the numbers from 1 to 20")
	  		case _ => error("Improper range of divisors")
	  	}
 	}
}