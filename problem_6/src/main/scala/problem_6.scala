object Main {

  def main(args: Array[String]) = println(sumSqrDiff(100))

  def sumSqrDiff(ub: Int) = ub * (ub + 1) / 2 * ( ub * (ub + 1) / 2 - (2 * ub + 1) / 3) 

}
