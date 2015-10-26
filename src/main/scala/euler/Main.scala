package euler

import scala.async.Async.{async, await}
import scala.concurrent.ExecutionContext.Implicits.global

object Main {
	def main(args: Array[String]): Unit = async {
		val solution1 = Problem1.exec()
		val solution2 = Problem2.exec()
		val solution3 = Problem3.exec()
		val solution4 = Problem4.exec()
		val solution5 = Problem5.exec()
		val solution6 = Problem6.exec()
		
		await(solution1)
		await(solution2)
		await(solution3)
		await(solution4)
		await(solution5)
		await(solution6)
 	}
}