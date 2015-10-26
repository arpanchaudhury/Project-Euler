package object euler {
	implicit class Tapper[T](val x: T) extends AnyVal {
	    def tap(msg: String = "tapped") = {
	      println(s"$msg: $x")
	      x
	    }
	}

	implicit class RichInt(val integer: Int) extends AnyVal {
		def isDivisableBy(divisor: Int) = (integer % divisor == 0)
	}
}