package com.yalingunayer.aoc.solutions

import org.scalatest._
import org.scalatest.FlatSpec

class Solution01aTests extends FlatSpec with Matchers {
  "solveFor(1111)" should "return correct answer 4" in {
    val result = Solution01a.solveFor("1111")

    result should be(4)
  }

  "solveFor(1122)" should "return correct answer 3" in {
    val result = Solution01a.solveFor("1122")

    result should be(3)
  }

  "solveFor(1234)" should "return correct answer 0" in {
    val result = Solution01a.solveFor("1234")

    result should be(0)
  }
}

class Solution01bTests extends FlatSpec with Matchers {
  "solveFor(1212)" should "return correct answer 6" in {
    val result = Solution01b.solveFor("1212")

    result should be(6)
  }

  "solveFor(1221)" should "return correct answer 0" in {
    val result = Solution01b.solveFor("1221")

    result should be(0)
  }

  "solveFor(123425)" should "return correct answer 4" in {
    val result = Solution01b.solveFor("123425")

    result should be(4)
  }

  "solveFor(123123)" should "return correct answer 12" in {
    val result = Solution01b.solveFor("123123")

    result should be(12)
  }

  "solveFor(12131415)" should "return correct answer 4" in {
    val result = Solution01b.solveFor("12131415")

    result should be(4)
  }
}
