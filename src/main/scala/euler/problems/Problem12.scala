package euler.problems

import euler._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Problem12 {
  def exec() = Future {
    val TriangleNumbers = NaturalNumbers.map(n => (1L to n).sum)
    val triangleNumbersWith500PlusFactors = TriangleNumbers.dropWhile(_.factors.size < 500)
    triangleNumbersWith500PlusFactors.head
  }
}