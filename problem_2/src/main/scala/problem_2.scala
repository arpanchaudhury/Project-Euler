package euler

object Main { 
  def main(args: Array[String]) = println((fib(4000000, List(2,1)) filter(x => (x%2 == 0))) sum)
  
  def fib(ub: Int, f: List[Int]): List[Int] = {
    val n = f.head + f.tail.first
    if(n >= ub) f else fib(ub, n +: f)
  }
}
