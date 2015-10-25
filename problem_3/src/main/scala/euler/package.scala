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