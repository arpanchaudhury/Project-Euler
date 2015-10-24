package object eular {
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
		def isDivisableBy(divisor: Int) = (integer % divisor == 0)
	}
}