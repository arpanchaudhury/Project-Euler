package euler.problems

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Problem6 {
  def exec() = Future {
    DifferenceOfSumSquareAndSquaresSumOfNaturalNumbersTill(100)
  }

  private def DifferenceOfSumSquareAndSquaresSumOfNaturalNumbersTill(upperBound: Int) =
    upperBound * (upperBound + 1) / 2 * (upperBound * (upperBound + 1) / 2 - (2 * upperBound + 1) / 3)
}
