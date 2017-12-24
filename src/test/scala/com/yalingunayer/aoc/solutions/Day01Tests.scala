package com.yalingunayer.aoc.solutions

import org.scalatest._
import org.scalatest.FlatSpec

class Solution01aTests extends BaseExpectationTest {
  val solver = Solution01a
  val expectations = Map("1111" -> 4, "1122" -> 3, "1234" -> 0)
  define
}

class Solution01bTests extends BaseExpectationTest {
  val solver = Solution01b
  val expectations = Map("1212" -> 6, "1221" -> 0, "123425" -> 4, "123123" -> 12, "12131415" -> 4)
  define
}
