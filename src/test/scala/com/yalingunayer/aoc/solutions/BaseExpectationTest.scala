package com.yalingunayer.aoc.solutions

import org.scalatest._

abstract class BaseExpectationTest extends FlatSpec with Matchers {
  val expectations: Map[String, Any]
  val solver: Solution

  def define = expectations.keys.map { key =>
    val value = expectations(key)
    f"solveFor ${key}" should f"return correct answer ${value}" in {
      solver.solveFor(key) should be(value)
    }
  }
}
