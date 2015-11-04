package euler.problems

import euler._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Problem10 {
  def exec() = Future {
    val PrimeUpperBound = 2000000L
    val range = Primes.takeWhile(_ < PrimeUpperBound)
    range.sum
  }
}