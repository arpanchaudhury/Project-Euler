package euler

object Main {

	def main(args: Array[String]) {
		val divisors = (1L to 20L).toStream
	  	lcm(divisors: _*) match {
	  		case Some(value) => value.tap("Smallest positive number that is evenly divisible by all of the numbers from 1 to 20")
	  		case _ => error("Improper range of divisors")
	  	}
 	}
}