import scala.io.StdIn
import scala.math._
import scala.annotation.tailrec

object Solution1 {
  def main(args: Array[String]): Unit = println(s"Day 1 solution 1: ${solution}.")

  def solution: String = {
    val stacksData = collectStacksData()
    val movesData = collectMoves()

    val stacks = stacksData.map(_.grouped(4).map(_(1).toChar).toList).reverse.transpose.map(l => {
      val stack = scala.collection.mutable.Stack[Char]()
      stack.pushAll(l.filter(letter => letter.compare(' ') != 0))
    })

    val regex = "move ([0-9]+) from ([0-9]+) to ([0-9]+)".r
    movesData
      .foreach(line => {
        val regex(moves, from, to) = line
        (1 to moves.toInt).foreach(i => stacks(to.toInt - 1).push(stacks(from.toInt - 1).pop) )
      })

    stacks
      .map(_.pop)
      .mkString
  }

  @tailrec
  def collectStacksData(stacksData: List[String] = List()): List[String] = {
    val line = StdIn.readLine
    line match {
      case line if line.exists(_.isDigit) => return stacksData
      case line => collectStacksData(stacksData :+ line)
    }
  }

  @tailrec
  def collectMoves(movesData: List[String] = List()): List[String] = {
    val line = StdIn.readLine
    line match {
      case null => return movesData
      case ""   => collectMoves(movesData)
      case line => collectMoves(movesData :+ line)
    }
  }
}

object Solution2 {
  def main(args: Array[String]): Unit = println(s"Day 1 solution 2: ${solution}.")

  def solution: String = {
    val arraysData = collectArraysData()
    val movesData = collectMoves()

    val arrays = arraysData.map(_.grouped(4).map(_(1).toChar).toList).transpose.map(l => {
      val array = scala.collection.mutable.ArrayBuffer[Char]()
      l
        .filter(letter => letter.compare(' ') != 0)
        .foreach(l => array += l)
      array 
    })

    val regex = "move ([0-9]+) from ([0-9]+) to ([0-9]+)".r
    movesData
      .foreach(line => {
        val regex(moves, from, to) = line
        arrays(to.toInt - 1).insertAll(0, arrays(from.toInt - 1).take(moves.toInt))
        arrays(from.toInt - 1).dropInPlace(moves.toInt)
      })

    arrays
      .map(_.head)
      .mkString
  }

  @tailrec
  def collectArraysData(arraysData: List[String] = List()): List[String] = {
    val line = StdIn.readLine
    line match {
      case line if line.exists(_.isDigit) => return arraysData 
      case line => collectArraysData(arraysData :+ line)
    }
  }

  @tailrec
  def collectMoves(movesData: List[String] = List()): List[String] = {
    val line = StdIn.readLine
    line match {
      case null => return movesData
      case ""   => collectMoves(movesData)
      case line => collectMoves(movesData :+ line)
    }
  }
}
