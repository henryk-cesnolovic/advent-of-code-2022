import scala.io.StdIn
import scala.math._
import scala.annotation.tailrec
import scala.collection.mutable.Stack

sealed trait Solution {
  @tailrec
  final def collectSums(sums: Map[String, Long] = Map(), nestedFolders: List[String]= List()): Map[String, Long] = {
    val line = StdIn.readLine
    line match {
      case null => return sums
      case line => {
        val splitted = line.split(" ")
        if(splitted(0) == "$" && splitted(1) == "cd")
          if(splitted(2) == "..")
            collectSums(sums, nestedFolders.tail)
          else {
            val path = if(nestedFolders.isEmpty) "/" else nestedFolders.head + splitted(2) + "/"
            collectSums(sums, path +: nestedFolders)
          }
        else if((splitted(0) == "$" && splitted(1) == "ls") || splitted(0) == "dir")
          collectSums(sums, nestedFolders)
        else if(splitted(0).forall(Character.isDigit)){
          val newSums = nestedFolders.map(folder => folder -> (splitted(0).toLong + sums.getOrElse(folder, 0L)))
          collectSums(sums ++ newSums, nestedFolders)
        }
        else
          collectSums(sums, nestedFolders)
      }
    }
  }
}

object Solution1 extends Solution{
  def main(args: Array[String]): Unit = println(s"Day 1 solution 1: ${solution}.")

  def solution: Long = {
    val collectedSums = collectSums()
    collectedSums
      .map{ case(k, v) => v}
      .filter(_ <= 100000L)
      .reduce(_ + _)
  }
}

object Solution2 extends Solution{
  def main(args: Array[String]): Unit = println(s"Day 1 solution 2: ${solution}.")

  def solution: Long = {
    val collectedSums = collectSums()
    collectedSums
      .map{ case(k, v) => v}
      .filter(v => 70000000L - collectedSums("/") + v >= 30000000L)
      .reduce(_ min _)
  }
}
