package euler.problems

import euler._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Problem7 {
  def exec() = Future {
    Stream.from(1).filter(_.isPrime)(10000)
  }
}
