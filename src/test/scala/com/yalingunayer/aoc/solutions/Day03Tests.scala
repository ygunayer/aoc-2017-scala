package com.yalingunayer.aoc.solutions

import org.scalatest._
import org.scalatest.FlatSpec

class Solution03StrategyTests extends FlatSpec with Matchers {
  "simple strategy" should "generate correct value for second point" in {
    val explored = Map(Solution03.Point.origin -> 1)
    val currentPosition = Solution03.Point.origin
    val currentDirection = Solution03.Direction.East()
    val newDirection = Solution03.Direction.North()

    val state = Solution03.TravelIterator(explored, currentDirection, currentPosition)

    val nextValue = Solution03.SimpleSpiralGenerator.getNextValue(state, newDirection)

    nextValue should be(2)
  }

  "simple strategy" should "generate correct value for third point" in {
    val explored = Map(Solution03.Point.origin -> 1, Solution03.Point.origin.right -> 2)
    val currentPosition = Solution03.Point.origin.right
    val currentDirection = Solution03.Direction.North()
    val newDirection = Solution03.Direction.West()

    val state = Solution03.TravelIterator(explored, currentDirection, currentPosition)

    val nextValue = Solution03.SimpleSpiralGenerator.getNextValue(state, newDirection)

    nextValue should be(3)
  }

  "neighbor sum strategy" should "generate correct value for second point" in {
    val explored = Map(Solution03.Point.origin -> 1)
    val currentPosition = Solution03.Point.origin
    val currentDirection = Solution03.Direction.East()
    val newDirection = Solution03.Direction.North()

    val state = Solution03.TravelIterator(explored, currentDirection, currentPosition)

    val nextValue = Solution03.NeighborSumSpiralGenerator.getNextValue(state, newDirection)

    nextValue should be(1)
  }

  "neighbor sum strategy" should "generate correct value for third point" in {
    val explored = Map(Solution03.Point.origin -> 1, Solution03.Point.origin.right -> 2)
    val currentPosition = Solution03.Point.origin.right
    val currentDirection = Solution03.Direction.North()
    val newDirection = Solution03.Direction.West()

    val state = Solution03.TravelIterator(explored, currentDirection, currentPosition)

    val nextValue = Solution03.NeighborSumSpiralGenerator.getNextValue(state, newDirection)

    nextValue should be(2)
  }
}

class Solution03aTests extends BaseExpectationTest {
  val solver = Solution03a
  val expectations = Map("1" -> 0, "12" -> 3, "23" -> 2, "1024" -> 31)
  define
}

class Solution03bTests extends BaseExpectationTest {
  val solver = Solution03b
  val expectations = Map("2" -> 4, "10" -> 11, "26" -> 54, "304" -> 330, "362" -> 747)
  define
}
