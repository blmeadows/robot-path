package sandbox

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

object RobotPath {

  def solutionRobotPath(r: Array[String]): Int = {
    // given a 2D matrix of size N x M represented by an array of strings:
    // Cleaning robot will clean one square at a time and will run indefinitely
    // robot can only take right turns at obstacle or end of matrix
    // determine how many squares will be cleaned
    // N and M are each [1..20]
    // top-left cell is empty
    // only will contain "." (empty) or "x" (obstacle)
    // start facing right

    var numOfSquares = 1
    var direction = 0 // 0: Right, 1: Down, 2: Left, 3: Top

    // ex: Array("...x..", "....xx", "..x...") == 6

    //Array(Array(('.', visited), ('.', visited), ('.', visited), ('x', visited), ('.', visited), ('.', visited),
    //            ('.', visited), ('.', visited), ('.', visited), ('.', visited), ('x', visited), ('x', visited),
    //            ('.', visited), ('.', visited), ('x', visited), ('.', visited), ('.', visited), ('.', visited))
    val floor: ArrayBuffer[ArrayBuffer[(Char, Int)]] = ArrayBuffer.from(r.map(i => ArrayBuffer.from(i.toCharArray.map(c => (c, 0)))))

    val columnLength = floor.length
    val rowLength = floor.head.length
    if (rowLength == 1 && columnLength == 1) numOfSquares
    else {
      var x = 0
      var y = 0
      floor(y)(x) = (floor(y)(x)._1, 1)

      def changeDirection(): Unit = {
        if (direction == 0) direction = 1
        else if (direction == 1) direction = 2
        else if (direction == 2) direction = 3
        else if (direction == 3) direction = 0
      }

      @tailrec
      def getNext(): Unit = {
        if (direction == 0) if (x + 1 >= rowLength || floor(y)(x + 1)._1 == 'x'){
          changeDirection()
          getNext()
        } else x = x + 1
        else if (direction == 1) if (y + 1 >= columnLength || floor(y + 1)(x)._1 == 'x'){
          changeDirection()
          getNext()
        } else y = y + 1
        else if (direction == 2) if (x - 1 < 0 || floor(y)(x - 1)._1 == 'x'){
          changeDirection()
          getNext()
        } else x = x - 1
        else if (direction == 3) if (y - 1 < 0 || floor(y - 1)(x)._1 == 'x'){
          changeDirection()
          getNext()
        } else y = y - 1
      }

      var loopFound = false
      while(!loopFound) {
        getNext()
        floor(y)(x) = (floor(y)(x)._1, floor(y)(x)._2 + 1)
        if (floor(y)(x)._2 == 1) numOfSquares += 1
        if (floor(y)(x)._2 == 100) loopFound = true
      }
      numOfSquares
    }
  }

}
