package com.yalingunayer.aoc

import com.yalingunayer.aoc.solutions.Solution

object Aoc2017 {
  def main(args: Array[String]): Unit = {
    val code = args.headOption

    code match {
      case Some(code) => {
        Solution.forCode(code) match {
          case Some(solver) => println(f"Solution for day ${code} is ${solver.solve}")
          case _ => throw new Exception(f"Solution for day ${code} is not yet implemented.")
        }
      }
      case _ => throw new Exception("Please provide a day number to solve")
    }
  }
}
