package euler.problems

import euler._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Problem9 {
  def exec() = Future {
    val triplets =
      for {
        first  <- 332 to 1 by -1
        second <- 499 to first + 1 by -1
        third  = 1000 - (first + second)
        if second < third
        if first * first + second * second == third * third
      } yield Triplet(first, second, third)
    assert(triplets.size == 1)
    val triplet = triplets(0)
    triplet._1 * triplet._2 * triplet._3
  }
}
