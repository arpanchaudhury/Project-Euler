package object euler {
	implicit class Tapper[T](val x: T) extends AnyVal {
	    def tap(msg: String = "tapped") = {
	      println(s"$msg: $x")
	      x
	    }
	}

	implicit class RichInt(val integer: Int) extends AnyVal {
		def isEven = integer % 2 == 0
		
		def isDivisableBy(divisor: Int) = (integer % divisor == 0)

		def isPalindrome: Boolean = {
			val stringRepresentationOfInteger = integer.toString
			stringRepresentationOfInteger == stringRepresentationOfInteger.reverse
		}

		def isMultipleOfTwoThreeDigitIntegers: Boolean = {
			val domain = (999 to 100 by -1).toStream
			val range = domain filter(this.isDivisableBy(_)) filter(n => (integer/n).isWithinBounds(100, 999))
			range.nonEmpty
		}

		def isWithinBounds(lowerBound: Int, upperBound: Int): Boolean = {
			integer >= lowerBound && integer <= upperBound
		}
	}

	implicit class RichLong(val longInteger: Long) extends AnyVal {
		def isPrime: Boolean = 
			if (longInteger == 1L) false 
			else {
				val domain = (2L to math.sqrt(longInteger).toLong).view
				val range = domain filter(this.isDivisableBy(_))
				range.isEmpty
			}

		def isDivisableBy(divisor: Long): Boolean = longInteger % divisor == 0
	}

	object RichInt {
		def gcd(numbers: Long*): Option[Long] = {
			def gcdOfTwoNumbers(n1: Long, n2: Long): Long = if (n2 == 0L) n1 else gcdOfTwoNumbers(n2, n1 % n2)

			numbers.length match {
			case 0 => None
			case 1 => Some(numbers(0))
			case _ =>
				val n1 = numbers(0)
				val n2 = numbers(1)
				val rest = numbers.drop(2)
				val gcdOfFirstTwoNumbers = gcdOfTwoNumbers(n1, n2)
				gcd((gcdOfFirstTwoNumbers +: rest): _*)
			}
		}

		def lcm(numbers: Long*): Option[Long] = numbers.length match {
			case 0 => None
			case 1 => Some(numbers(0))
			case _ =>
				val n1 = numbers(0)
				val n2 = numbers(1)
				val rest = numbers.drop(2)
				val productOfFirstTwoNumbers = n1 * n2
				val gcdOfFirstTwoNumbers = gcd(n1, n2).get
				val lcmOfFirstTwoNumbers = productOfFirstTwoNumbers / gcdOfFirstTwoNumbers
				lcm((lcmOfFirstTwoNumbers +: rest): _*)
		}
	}
}