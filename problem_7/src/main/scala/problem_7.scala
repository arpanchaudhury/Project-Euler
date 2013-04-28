object Main {

  def main(args: Array[String]) = println(getNextPrime(getNextPrime(2,List()).head + 1,getNextPrime(2,List())))

  def getNextPrime(lb: Int, primes: List[Int]): List[Int] = if (isPrime(lb, primes)) (lb :: primes) else getNextPrime(lb + 1, primes)

  def isPrime(n: Int, primes: List[Int]): Boolean = primes match {
    case x :: xs => if (n % x == 0) false else isPrime(n, xs)
    case _ => true
  }

}
