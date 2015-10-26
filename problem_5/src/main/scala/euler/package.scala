package object euler {
	implicit class Tapper[T](val x: T) extends AnyVal {
	    def tap(msg: String = "tapped") = {
	      println(s"$msg: $x")
	      x
	    }
	}

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