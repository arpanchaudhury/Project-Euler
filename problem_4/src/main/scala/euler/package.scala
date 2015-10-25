package object euler {
	implicit class Tapper[T](val x: T) extends AnyVal {
	    def tap(msg: String = "tapped") = try {
	      println(s"$msg: $x")
	      x
	    } catch {
	      case ex: Throwable =>
	        println(s"$msg: <error> $ex")
	        throw ex
	    }
	}

	implicit class RichInt(val integer: Int) extends AnyVal {
		def isPalindrome: Boolean = {
			val stringRepresentationOfInteger = integer.toString
			stringRepresentationOfInteger == stringRepresentationOfInteger.reverse
		}

		def isMultipleOfTwoThreeDigitIntegers: Boolean = {
			val domain = (999 to 100 by -1).toStream
			val range = domain filter(this.isDivisableBy(_)) filter(n => (integer/n).isWithinBounds(100, 999))
			range.nonEmpty
		}

		def isDivisableBy(divisor: Int): Boolean = integer % divisor == 0

		def isWithinBounds(lowerBound: Int, upperBound: Int): Boolean = {
			integer >= lowerBound && integer <= upperBound
		}
	}
}