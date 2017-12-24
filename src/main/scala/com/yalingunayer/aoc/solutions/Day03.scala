package com.yalingunayer.aoc.solutions

import com.yalingunayer.aoc.Utils

object Solution03 {
  trait Vector {
    val x: Int
    val y: Int

    def +[A <: Vector](v: A) = Point(x + v.x, y + v.y)
    def distanceTo[A <: Vector](v: A) = Math.abs(v.x - x) + Math.abs(v.y - y)
  }

  abstract class Direction(val dx: Int, val dy: Int) extends Vector {
    val x = dx
    val y = dy

    def turnLeft: Direction
  }

  object Direction {
    case class None() extends Direction(0, 0) { def turnLeft = East() }
    case class North() extends Direction(0, 1) { def turnLeft = West() }
    case class West() extends Direction(-1, 0) { def turnLeft = South() }
    case class East() extends Direction(1, 0) { def turnLeft = North() }
    case class South() extends Direction(0, -1) { def turnLeft = East() }

    case class NorthEast() extends Direction(1, 1) { def turnLeft = NorthWest() }
    case class NorthWest() extends Direction(-1, 1) { def turnLeft = SouthWest() }
    case class SouthWest() extends Direction(-1, -1) { def turnLeft = SouthEast() }
    case class SouthEast() extends Direction(1, -1) { def turnLeft = NorthEast() }

    def all: Seq[Direction] = List(East(), SouthEast(), South(), SouthWest(), West(), NorthWest(), North(), NorthEast())
  }

  object Point {
    lazy val origin = Point(0, 0)
  }

  case class Point(x: Int, y: Int) extends Vector {
    def up: Point = this + Direction.North()
    def right: Point = this + Direction.East()
    def down: Point = this + Direction.South()
    def left: Point = this + Direction.West()

    def neighbors: Seq[Point] = Direction.all.map(direction => this + direction)
  }

  case class Node(coordinates: Point, value: Int)

  case class TravelIterator(explored: Map[Point, Int], direction: Direction, current: Point) {
    val currentValue: Int = explored.get(current).getOrElse(0)
  }

  abstract class ValueGenerationStrategy {
    def getNextValue(state: TravelIterator, direction: Solution03.Direction): Int
  }

  object SimpleSpiralGenerator extends ValueGenerationStrategy {
    def getNextValue(state: TravelIterator, direction: Solution03.Direction): Int = state.currentValue + 1
  }

  object NeighborSumSpiralGenerator extends ValueGenerationStrategy {
    def getNextValue(state: TravelIterator, direction: Solution03.Direction): Int = {
      val nextPos = state.current + direction
      val fullNeighbors = nextPos.neighbors.flatMap(p => state.explored.get(p))
      fullNeighbors.sum
    }
  }
}

abstract class Solution03 extends Solution(3) {

  override lazy val input: String = "277678"
  implicit val strategy: Solution03.ValueGenerationStrategy

  def makeSpiral(implicit strategy: Solution03.ValueGenerationStrategy): Iterator[Solution03.TravelIterator] = {
    val initialMap = Map(Solution03.Point.origin -> 1)

    val initial = Solution03.TravelIterator(initialMap, Solution03.Direction.East(), Solution03.Point.origin)

    Iterator.iterate(initial)(log => {
      val current = log.current
      val currentValue = log.currentValue
      val left = log.direction.turnLeft

      val newDirection = if (log.explored.isDefinedAt(current + left)) log.direction else log.direction.turnLeft
      val newPosition = current + newDirection

      val newExplored = log.explored + (newPosition -> strategy.getNextValue(log, newDirection))

      Solution03.TravelIterator(newExplored, newDirection, newPosition)
    })
  }

}

object Solution03a extends Solution03 {
  implicit val strategy = Solution03.SimpleSpiralGenerator

  def solveFor(input: String): Int = {
    val n = input.toInt
    val last = makeSpiral.dropWhile(t => t.currentValue < n).next
    last.current.distanceTo(Solution03.Point.origin)
  }
}

object Solution03b extends Solution03 {
  implicit val strategy = Solution03.NeighborSumSpiralGenerator

  def solveFor(input: String): Int = {
    val n = input.toInt
    makeSpiral.dropWhile(t => t.currentValue <= n).next.currentValue
  }
}
