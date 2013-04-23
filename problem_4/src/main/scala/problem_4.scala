import scala.util.control.Breaks._

object Main {

  def main(args: Array[String]) = {
    for (i <- (999*999) to (100*100) by -1) 
      if (isPalindrome(i) && isValid(i)) {
        println(i)
        break
      }
  }
  
  def isPalindrome(n: Int): Boolean = n.toString == n.toString.reverse

  def isValid(n: Int): Boolean = {
    for (i <- 999 to 100 by -1)
      if (n % i == 0 && n/i > 99 && n/i < 1000)
        return true
    false
  }

}
