package euler

object Main {
  def main(args: Array[String]) {
  	val number = 600851475143L
  	val domain = (math.sqrt(number).toLong to 2L by -1).view
  	val range = domain filter(number.isDivisableBy(_)) filter(_.isPrime)
  	val largestPrimeFactor = range(0)
    largestPrimeFactor.tap("Largest prime factor of the number 600851475143")
  }
}
