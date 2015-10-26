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
		
		await(solution1).tap("Problem 1: Sum of all numbers divisable by 3 and 5 between 1 to 999 is")
		await(solution2).tap("Problem 2: Sum of even valued terms of fibonacci series whose values do not exceed four million")
		await(solution3).tap("Problem 3: Largest prime factor of the number 600851475143")
		await(solution4).tap("Problem 4: Largest palindrome made from the product of two 3-digit numbers")
		await(solution5).tap("Problem 5: Smallest positive number that is evenly divisible by all of the numbers from 1 to 20")
		await(solution6).tap("Problem 6: Difference between the sum of the squares of the first one hundred natural numbers and the square of the sum")
 	}
}