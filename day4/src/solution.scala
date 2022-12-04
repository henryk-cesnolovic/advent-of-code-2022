import scala.io.StdIn
import scala.math._
import scala.annotation.tailrec

object Solution1 {
  def main(args: Array[String]): Unit = println(s"Day 1 solution 1: ${solution()}.")

  @tailrec
  def solution(sum: Long = 0): Long = {
    val line = StdIn.readLine
    line match {
      case null => return sum
      case line => {
        val Array(l, r) = line.split(",")
        val Array(ll, lr) = l.split("-").map(_.toInt)
        val Array(rl, rr) = r.split("-").map(_.toInt)
        if((rl <= ll && ll <= rr && rl <= lr && lr <= rr) ||
           (ll <= rl && rl <= lr && ll <= rr && rr <= lr)) solution(sum + 1)
        else solution(sum)
      }
    }
  }
}

object Solution2 {
  def main(args: Array[String]): Unit = println(s"Day 1 solution 2: ${solution()}.")

  @tailrec
  def solution(sum: Long = 0): Long = {
    val line = StdIn.readLine
    line match {
      case null => return sum
      case line => {
        val Array(l, r) = line.split(",")
        val Array(ll, lr) = l.split("-").map(_.toInt)
        val Array(rl, rr) = r.split("-").map(_.toInt)
        if((rl <= ll && ll <= rr || rl <= lr && lr <= rr) ||
           (ll <= rl && rl <= lr || ll <= rr && rr <= lr)) solution(sum + 1)
        else solution(sum)
      }
    }
  }
}
