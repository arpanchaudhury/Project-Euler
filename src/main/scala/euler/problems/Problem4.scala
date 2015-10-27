package euler.problems

import euler._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Problem4 {
  def exec() = Future {
    val lowerBound = 100 * 100
    val upperBound = 999 * 999
    largestPalindromicNaturalNumber(lowerBound, upperBound)
  }

  private def largestPalindromicNaturalNumber(lowerBound: Int = 0, upperBound: Int = Integer.MAX_VALUE): Int = {
    if (upperBound < 0) sys.error("Upper bound must be a natural number")
    else if (upperBound < lowerBound) sys.error("No palindromic natural number found with in given bounds")
    else if (upperBound.isPalindrome && upperBound.isMultipleOfTwoThreeDigitIntegers) upperBound
    else largestPalindromicNaturalNumber(lowerBound, upperBound - 1)
  }
}
