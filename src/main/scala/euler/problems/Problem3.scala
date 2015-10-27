package euler.problems

import euler._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Problem3 {
  def exec() = Future {
    val number = 600851475143L
    val domain = (math.sqrt(number).toLong to 2L by -1).view
    val range = domain filter(number.isDivisibleBy(_)) filter(_.isPrime)
    val largestPrimeFactor = range(0)
    largestPrimeFactor
  }
}
