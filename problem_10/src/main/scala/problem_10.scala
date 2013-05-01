package euler

object Main {

  def main(args: Array[String]) = println(getPrimeList(2000000, List()).map(x => x.toLong).sum)
 
  def getPrimeList(ub: Int, primes: List[Int]): List[Int] = {
    val x = getNextPrime(primes)
    if (x.head <= ub) getPrimeList(ub, x) else primes
  }

  def getNextPrime(primes: List[Int]): List[Int] = if (primes.isEmpty) List(2) else getNextPrimeHelper(primes.head + 1, primes)

  def getNextPrimeHelper(lb: Int, primes: List[Int]): List[Int] = {
    if (isPrime(lb, primes)) (lb :: primes) else getNextPrimeHelper(lb + 1, primes)
  }

  def isPrime(n: Int, primes: List[Int]): Boolean = primes match {
    case x :: xs => if (n % x == 0) false else isPrime(n, xs)
    case _ => true
  }

}
