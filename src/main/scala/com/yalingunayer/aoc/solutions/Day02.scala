package com.yalingunayer.aoc.solutions

import com.yalingunayer.aoc.Utils

abstract class Solution02 extends Solution(2) {
  def parseRows(input: String) = input.split("\\r?\\n").map(row => row.split("\\s+").map(_.toInt))
}

object Solution02a extends Solution02 {
  def solveFor(input: String): Int = parseRows(input).map(row => row.max - row.min).sum
}

object Solution02b extends Solution02 {
  def findDivisionSum(list: List[Int]): Int = list match {
    case x :: xs if x != 1 && x != 0 => {
      val sum = xs.filter(n => n % x == 0).map(n => n / x).sum
      sum + findDivisionSum(xs)
    }
    case _ => 0
  }

  def solveFor(input: String): Int = parseRows(input).map(row => findDivisionSum(row.toList.sorted)).sum
}
