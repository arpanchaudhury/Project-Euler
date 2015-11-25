package euler

import euler.problems._

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
		val solution7 = Problem7.exec()
		val solution8 = Problem8.exec()
		val solution9 = Problem9.exec()
		val solution10 = Problem10.exec()
		val solution11 = Problem11.exec()
		val solution12 = Problem12.exec()

		await(solution1).tap("Problem 1: Sum of all numbers divisible by 3 and 5 between 1 to 999 is")
		await(solution2).tap("Problem 2: Sum of even valued terms of fibonacci series whose values do not exceed four million")
		await(solution3).tap("Problem 3: Largest prime factor of the number 600851475143")
		await(solution4).tap("Problem 4: Largest palindrome made from the product of two 3-digit numbers")
		await(solution5).tap("Problem 5: Smallest positive number that is evenly divisible by all of the numbers from 1 to 20")
		await(solution6).tap("Problem 6: Difference between the sum of the squares of the first one hundred natural numbers and the square of the sum")
		await(solution7).tap("Problem 7: 10001 prime number")
		await(solution8).tap("Problem 8: Thirteen adjacent digits in the 1000-digit number that have the greatest product")
		await(solution9).tap("Problem 9: Product of the Pythagorean triplet whose sum is 1000")
		await(solution10).tap("Problem 10: Sum of all the primes below two million")
		await(solution11).tap("Problem 11: The greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally)")
		await(solution12).tap("Problem 12: Value of the first triangle number to have over five hundred divisors")
 	}
}