package euler.problems

import euler._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Problem7 {
  def exec() = Future(Primes(10000))
}
