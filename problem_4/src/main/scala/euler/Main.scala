package euler

object Main {

  def main(args: Array[String]) {
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