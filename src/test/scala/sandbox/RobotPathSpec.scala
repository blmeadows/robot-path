package sandbox

import sandbox.RobotPath._

class RobotPathSpec extends munit.ScalaCheckSuite {

  test("Robot Path 1") {
    val array = Array("...x..", "....xx", "..x...")
    val result = 6

    assert(solutionRobotPath(array) == result)
  }

  test("Robot Path 2") {
    val array = Array("....x..", "x......", ".....x.", ".......")
    val result = 15

    assert(solutionRobotPath(array) == result)
  }

  test("Robot Path 3") {
    val array = Array("...x.", ".x..x", "x...x", "..x..")
    val result = 9

    assert(solutionRobotPath(array) == result)
  }

  test("Robot Path 4") {
    val array = Array(".")
    val result = 1

    assert(solutionRobotPath(array) == result)
  }

  test("Robot Path 5") {
    val array = Array("..x", "..x")
    val result = 4

    assert(solutionRobotPath(array) == result)
  }

  test("Robot Path 6") {
    val array = Array("...x", "xx.x", "x..x", "x..x")
    val result = 8

    assert(solutionRobotPath(array) == result)
  }

  test("Robot Path 7") {
    val array = Array("....................", "....................", "....................", "....................", "....................", "....................", "....................", "....................", "....................", "....................", "....................", "....................", "....................", "....................", "....................", "....................", "....................", "....................", "....................", "....................")
    val result = 76 // will only get the edges

    assert(solutionRobotPath(array) == result)
  }

}
