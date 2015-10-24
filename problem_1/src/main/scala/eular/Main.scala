package eular	

object Main {
  def main(args: Array[String]) {
  	val domain = (1 to 999)
  	val range = domain filter {
  		x => x.isDivisableBy(3) || x.isDivisableBy(5)
  	}
  	range.sum.tap("Sum of all numbers divisable by 3 and 5 between 1 to 999 is")
  }
}