import scala.io.StdIn
import scala.math._
import scala.annotation.tailrec

object Solution1 {
  def main(args: Array[String]): Unit = println(s"Day 1 solution 1: ${solution()}.")

  @tailrec
  def solution(sum: Long = 0, maxSum: Long = 0): Long = {
    val line = StdIn.readLine
    line match {
      case null => return max(sum, maxSum)
      case line => if(line != "") solution(sum + line.toLong, maxSum) else solution(0, max(sum, maxSum))
    }
  }
}

object Solution2 {
  def main(args: Array[String]): Unit = println(s"Day 1 solution 2: ${solution}.")

  def solution = collectSums()
    .sortBy(-_)
    .take(3)
    .reduce(_ + _)

  @tailrec
  def collectSums(sum: Long = 0, allSums: Seq[Long] = Seq()): Seq[Long] = {
    val line = StdIn.readLine
    line match {
      case null => return allSums :+ sum
      case line => if(line != "") collectSums(sum + line.toLong, allSums) else collectSums(0, allSums :+ sum)
    }
  }
}
