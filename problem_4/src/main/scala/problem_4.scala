object Main {
  def main(args: Array[String]) = println(isPalindrome(555555))
  
  def isPalindrome(n: Int): Boolean = {
    val x = countDigits(n)
    if (n % 10 != n / math.pow(10, x - 1)) false else isPalindrome(n - n/10)
  } 
  
  def countDigits(n: Int, count: Int): Int = if (n/10 == 0) (count + 1) else countDigits(n/10, count + 1) 
}
