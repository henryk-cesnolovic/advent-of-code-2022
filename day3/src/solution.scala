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
        val List(left, right) = line.grouped(line.size / 2).toList
        val common = left.intersect(right)(0).toChar
        val value = if(common.isLower) common - 'a' + 1 else common - 'A' + 27
        solution(sum + value)
      }
    }
  }
}

object Solution2 {
  def main(args: Array[String]): Unit = println(s"Day 1 solution 2: ${solution()}.")
  
  @tailrec
  def solution(group: List[String] = List(), sum: Long = 0): Long = {
    val line = StdIn.readLine
    line match {
      case null => sum
      case line => {
        val newGroup = group :+ line 
        if(newGroup.size == 3){
          val List(first, second, third) = newGroup
          val common = first.intersect(second).intersect(third)(0).toChar
          val value = if(common.isLower) common - 'a' + 1 else common - 'A' + 27
          solution(List(), sum + value)
        }
        else
          solution(newGroup, sum)
      }
    }
  }
}
