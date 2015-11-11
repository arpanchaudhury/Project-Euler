package euler.problems

import euler._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Problem4 {
  def exec() = Future {
    val lowerBound = 100 * 100
    val upperBound = 999 * 999
    val domain = (upperBound to lowerBound by -1).toStream
    val palindromes = domain.filter(_.isPalindrome)
    val palindromicMultipleOfTwoThreeDigitIntegers = palindromes.filter(_.isMultipleOfTwoThreeDigitIntegers)
    palindromicMultipleOfTwoThreeDigitIntegers(0)
  }
}
