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

object Problem7 {
  def exec() = Future {
    Stream.from(1).filter(_.isPrime)(10000)
  }
}

object Problem8 {
  def exec() = Future {
    val NumberOfDigits = 13
    val InputNumber = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450"
    val inputDigits = InputNumber.map(_.toExactLong)
    val digitGroups = inputDigits.sliding(NumberOfDigits)
    val productOfDigitGroups = digitGroups.map(_.product)
    productOfDigitGroups.max
  }
}

object Problem9 {
  def exec() = Future {
    val triplets =
      for {
        first  <- 332 to 1 by -1
        second <- 499 to first + 1 by -1
        third  = 1000 - (first + second)
        if second < third
        if first * first + second * second == third * third
      } yield Triplet(first, second, third)
    assert(triplets.size == 1)
    val triplet = triplets(0)
    triplet._1 * triplet._2 * triplet._3
  }
}

object Problem10 {
  def exec() = Future {
    val PrimeUpperBound = 2000000L
    val primes = Stream.from(1).map(_.toLong).filter(_.isPrime)
    primes.takeWhile(_ < PrimeUpperBound).sum
  }
}