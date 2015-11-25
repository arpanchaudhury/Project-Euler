package object euler {

  object Triplet {
    def apply[T](_1: T, _2: T, _3: T) = Tuple3[T, T, T](_1, _2, _3)
  }

  implicit class Tapper[T](val x: T) extends AnyVal {
    def tap(msg: String = "tapped") = {
      println(s"$msg: $x")
      x
    }
  }

  implicit class RichInt(val integer: Int) extends AnyVal {
    def isEven = integer % 2 == 0

    def isDivisibleBy(divisor: Int) = integer % divisor == 0

    def isPalindrome: Boolean = {
      val stringRepresentationOfInteger = integer.toString
      stringRepresentationOfInteger == stringRepresentationOfInteger.reverse
    }

    def isMultipleOfTwoThreeDigitIntegers: Boolean = {
      val domain = (999 to 100 by -1).toStream
      val range = domain filter (this.isDivisibleBy(_)) filter (n => (integer / n).isWithinBounds(100, 999))
      range.nonEmpty
    }

    def isWithinBounds(lowerBound: Int, upperBound: Int): Boolean = {
      integer >= lowerBound && integer <= upperBound
    }

    def isPrime: Boolean =
      if (integer == 1) false
      else {
        val domain = (2 to math.sqrt(integer).toInt).view
        val range = domain filter (this.isDivisibleBy(_))
        range.isEmpty
      }
  }

  implicit class RichLong(val longInteger: Long) extends AnyVal {
    def isPrime: Boolean =
      if (longInteger == 1L) false
      else {
        val domain = (2L to math.sqrt(longInteger).toLong).view
        val range = domain filter (this.isDivisibleBy(_))
        range.isEmpty
      }

    def isDivisibleBy(divisor: Long): Boolean = longInteger % divisor == 0

    def factors: Set[Long] = {
      val coFactors = for {
                        n <- 1L to Math.sqrt(longInteger).toLong
                        if longInteger % n == 0
                      } yield (n, longInteger / n)
      (coFactors.unzip_1 ++ coFactors.unzip_2).toSet
    }
  }

  implicit class RichChar(val char: Char) extends AnyVal {
    def toExactLong: Long =
      if (char >= '0' && char <= '9') char.toLong - '0'
      else sys.error("cannot be converted to exact Long")
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
          gcd(gcdOfFirstTwoNumbers +: rest: _*)
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
        lcm(lcmOfFirstTwoNumbers +: rest: _*)
    }
  }

  implicit class RichList[T](val list: List[T]) extends AnyVal {
    def lazyMap[U](mapFunction: T => U): Stream[U] = list match {
      case List() => Stream[U]()
      case x :: xs => Stream.cons(mapFunction(list.head), list.tail.lazyMap(mapFunction))
    }

    def lazyFlatMap[U](mapFunction: T => Stream[U]): Stream[U] = list match {
      case List() => Stream[U]()
      case x :: xs => mapFunction(list.head) #::: list.tail.lazyFlatMap(mapFunction)
    }

    def lazyFilter(predicate: T => Boolean): Stream[T] = list match {
      case List() => Stream[T]()
      case x :: xs if predicate(list.head) => Stream.cons(list.head, list.tail.lazyFilter(predicate))
      case x :: xs => list.tail.lazyFilter(predicate)
    }
  }

  implicit class RichIndexSeq[T](val seq: IndexedSeq[T]) extends AnyVal {
    def takeUntil(predicate: T => Boolean): IndexedSeq[T] = {
      seq.span(predicate) match {
        case (listA, listB) if listB.isEmpty => listA
        case (listA, listB) => listA :+ listB.head
      }
    }
  }

  implicit class _Tuple_RichIndexSeq[T, U](val seq: IndexedSeq[(T, U)]) extends AnyVal {
    def unzip_1: IndexedSeq[T] = seq.unzip._1

    def unzip_2: IndexedSeq[U] = seq.unzip._2
  }

  val NaturalNumbers = Stream.from(1).map(_.toLong)
  val Primes = NaturalNumbers.filter(_.isPrime)
}