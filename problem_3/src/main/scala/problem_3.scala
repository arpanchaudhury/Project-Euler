object Main {
  def main(args: Array[String]) = {
    println(((2L to math.sqrt(600851475143L).toLong) filter (x => (600851475143L % x == 0) && isPrime(x))).last)
  }

  def isPrime (x: Long): Boolean = if (x == 1L) false else ((2L to math.sqrt(x).toLong) filter (n => (x%n == 0))).isEmpty
}
