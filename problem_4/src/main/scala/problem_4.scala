import scala.util.control.Breaks._

object Main {

  def main(args: Array[String]) = {
    println(test(999 * 999))
  }
  
  def test(n: Int): Int = if (isPalindrome(n) && isValid(n)) return n else test(n - 1)
         
  def isPalindrome(n: Int): Boolean = n.toString == n.toString.reverse

  def isValid(n: Int): Boolean = {
    for (i <- 999 to 100 by -1)
      if (n % i == 0 && n/i > 99 && n/i < 1000)
        return true
    false
  }

}
