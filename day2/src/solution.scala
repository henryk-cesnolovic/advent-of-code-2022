import scala.io.StdIn
import scala.math._
import scala.annotation.tailrec

object Solution1 {
  def main(args: Array[String]): Unit = println(s"Day 2 solution 1: ${solution()}.")

  def scoring(left:String, right: String): Int = {
    val shapeScoreMap: Map[String, Int] = Map(
      "X" -> 1,
      "Y" -> 2,
      "Z" -> 3
    )

    val gameScore = 
      if((left == "A" && right == "X") || (left == "B" && right == "Y") || (left == "C" && right == "Z")) 3
      else if((left == "A" && right == "Y") || (left == "B" && right == "Z") || (left == "C" && right == "X")) 6
      else 0

    shapeScoreMap(right) + gameScore
  }

  @tailrec
  def solution(sum: Long = 0L): Long = {
    val line = StdIn.readLine()
    line match {
      case null => sum
      case line => {
        val Array(left, right) = line.split(" ")
        solution(sum + scoring(left, right))
      }
    }
  }
}

object Solution2 {
  def main(args: Array[String]): Unit = println(s"Day 2 solution 2: ${solution()}.")

  def scoring(left:String, right: String): Int = {
    val gameScoreMap: Map[String, Int] = Map(
      "X" -> 0,
      "Y" -> 3,
      "Z" -> 6
    )

    val shapeScore: Int = 
      if((left == "A" && right == "Y") || (left == "B" && right == "X") || (left == "C" && right == "Z")) 1
      else if((left == "B" && right == "Y") || (left == "C" && right == "X") || (left == "A" && right == "Z")) 2
      else 3

    gameScoreMap(right) + shapeScore
  }

  @tailrec
  def solution(sum: Long = 0L): Long = {
    val line = StdIn.readLine()
    line match {
      case null => sum
      case line => {
        val Array(left, right) = line.split(" ")
        solution(sum + scoring(left, right))
      }
    }
  }
}
