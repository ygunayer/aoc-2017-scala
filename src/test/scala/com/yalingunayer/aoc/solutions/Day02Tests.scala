package com.yalingunayer.aoc.solutions

import org.scalatest._
import org.scalatest.FlatSpec

class Solution02aTests extends FlatSpec with Matchers {
  "solveFor simpleCase" should "return correct answer 18" in {
    val input = """5 1 9 5
7 5 3
2 4 6 8"""
    val result = Solution02a.solveFor(input)

    result should be(18)
  }
}

class Solution02bTests extends FlatSpec with Matchers {
  "solveFor simpleCase" should "return correct answer 9" in {
    val input = """5 9 2 8
9 4 7 3
3 8 6 5"""
    val result = Solution02b.solveFor(input)

    result should be(9)
  }
}
