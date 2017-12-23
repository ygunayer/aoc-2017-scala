package com.yalingunayer.aoc.solutions

import com.yalingunayer.aoc.Utils

abstract class Solution01 extends Solution(1) {

}

object Solution01a extends Solution01 {
  case class SolveIterator(sum: Int, last: Char)

  def solveFor(input: String): Int = input.foldLeft(SolveIterator(0, input.last))((acc, current) => current match {
    case acc.last => SolveIterator(acc.sum + current.asDigit, current)
    case _ => SolveIterator(acc.sum, current)
  }).sum;
}

object Solution01b extends Solution01 {
  def solveFor(input: String): Int = {
    val halfLength = input.length / 2

    Range(0, halfLength).foldLeft(0)((sum, i) => {
      val c = input(i)
      if (c.equals(input(i + halfLength))) {
        sum + c.asDigit
      } else {
        sum
      }
    }) * 2
  }
}
