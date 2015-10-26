package object euler {
	implicit class Tapper[T](val x: T) extends AnyVal {
	    def tap(msg: String = "tapped") = {
	      println(s"$msg: $x")
	      x
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
}