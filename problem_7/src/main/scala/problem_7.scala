object Main {

  def main(args: Array[String]) = println(getPrimeList(10001).head)

  def getPrimeList(times: Int): List[Int] = if (times == 0) List() else getNextPrime(getPrimeList(times - 1))

  def getNextPrime(primes: List[Int]): List[Int] = if (primes.isEmpty) List(2) else getNextPrimeHelper(primes.head + 1, primes)

  def getNextPrimeHelper(lb: Int, primes: List[Int]): List[Int] = if (isPrime(lb, primes)) (lb :: primes) else getNextPrimeHelper(lb + 1, primes)

  def isPrime(n: Int, primes: List[Int]): Boolean = primes match {
    case x :: xs => if (n % x == 0) false else isPrime(n, xs)
    case _ => true
  }

}
