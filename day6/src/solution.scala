import scala.io.StdIn
import scala.math._
import scala.annotation.tailrec


object Solution1 {
  def main(args: Array[String]): Unit = println(s"Day 1 solution 1: ${solution}.")

  @tailrec
  def calc(text: List[Char], position: Long = 1L): Long =
    text match {
      case s1 :: s2 :: s3 :: s4 :: rest => if(Set(s1, s2, s3, s4).size == 4) position + 3 else calc(List(s2, s3, s4) ++ rest, position + 1)
      case _ => 0
    }

  def solution: Long = {
    val line = StdIn.readLine
    calc(line.toCharArray.toList)
  }
}

object Solution2 {
  def main(args: Array[String]): Unit = println(s"Day 1 solution 2: ${solution}.")

  @tailrec
  def calc(text: List[Char], position: Long = 1L): Long =
    text match {
      case s1 :: s2 :: s3 :: s4 :: s5 :: s6 :: s7 :: s8 :: s9 :: s10 :: s11 :: s12 :: s13 :: s14 :: rest => 
        if(Set(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14).size == 14) position + 13 
        else calc(List(s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14) ++ rest, position + 1)
      case _ => 0
    }

  def solution: Long = {
    val line = StdIn.readLine
    calc(line.toCharArray.toList)
  }
}
