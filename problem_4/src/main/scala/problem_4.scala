import scala.util.control.Breaks._

object Main {
  def main(args: Array[String]) = {
    for(i <- 999 to 100 by -1) 
      for (j <- i to 100 by -1) 
        if (isPalindrome(i * j)) {
          println((i * j))
          break
        }
  }
  
  def isPalindrome(n: Int): Boolean = {
    val x = countDigits(n, 0)
    if (x == 0 || x == 1)
      true
    else if (n % 10 != (n / math.pow(10, x - 1)).toInt)
      false 
    else 
      isPalindrome(((n - n % 10 * math.pow(10, x - 1).toInt) / 10).toInt)
  } 
  
  def countDigits(n: Int, count: Int): Int = if (n/10 == 0) (count + 1) else countDigits(n/10, count + 1) 
}
