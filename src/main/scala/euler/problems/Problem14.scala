package euler.problems

import euler._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Problem14 {
  def exec() = Future {
    val million = 1000000
    val domain = NaturalNumbers.take(million)
    val numbersWithCollatzSequencesSize = domain.map(n => (n, n.generateCollatzSeq.size))
    val (numberWithLongestCollatzSequence, _) = numbersWithCollatzSequencesSize.maxBy(_._2)
    numberWithLongestCollatzSequence
  }
}