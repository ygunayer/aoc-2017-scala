package com.yalingunayer.aoc.solutions

import com.yalingunayer.aoc.Utils

object Solution {
  def forCode(code: String): Option[Solution] = Utils.ReflectionUtils.getObjectInstance(f"com.yalingunayer.aoc.solutions.Solution${code}")
}

abstract class Solution(val dayNumber: Int) {
  lazy val input = Utils.InputUtils.loadFile(f"/day${dayNumber}%02d.input")

  def solve: String = solveFor(input)
  def solveFor(input: String): Int
  def solveAsStringFor(input: String): String = solveFor(input).toString

  implicit def resultAsString(x: Int): String = x.toString
}
