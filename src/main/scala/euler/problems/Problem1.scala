package euler.problems

import euler._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Problem1 {
  def exec() = Future {
    val domain = 1 to 999
    val range = domain filter {
      number => number.isDivisibleBy(3) || number.isDivisibleBy(5)
    }
    range.sum
  }
}
