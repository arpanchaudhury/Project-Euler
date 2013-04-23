object Main {

  def main(args: Array[String]) = println((1L to 20L).foldLeft(1L)((i,j) => lcm(i, j)))

  def lcm(a: Long, b: Long): Long = (a * b) / gcd(a, b)

  def gcd(a: Long, b: Long): Long =  if (b == 0L) a else gcd(b, a % b)

}
