object Main {
  def main(args: Array[String]) = println(isPalindrome(31213))
  
  def isPalindrome(n: Int): Boolean = {
    val x = countDigits(n, 0)
    if (x == 0 || x == 1)
      true
    else if (n % 10 != (n / math.pow(10, x - 1)).toInt)
      false 
    else 
      isPalindrome(((n - n % 10 * (math.pow(10, x - 1).toInt + 1)) / 10).toInt)
  } 
  
  def countDigits(n: Int, count: Int): Int = if (n/10 == 0) (count + 1) else countDigits(n/10, count + 1) 
}
