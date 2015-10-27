package euler.problems

import euler._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Problem5 {
  def exec() = Future {
    val divisors = (1L to 20L).toStream
    RichInt.lcm(divisors: _*) match {
      case Some(value) => value
      case _ => sys.error("Improper range of divisors")
    }
  }
}
