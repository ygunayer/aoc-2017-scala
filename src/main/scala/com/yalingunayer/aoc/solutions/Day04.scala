package com.yalingunayer.aoc.solutions

object Solution04 {
  abstract class PassPhraseValidator {
    def validate(phrases: Seq[String]): Boolean
  }

  object UniquePassPhraseValidator extends PassPhraseValidator {
    def validate(phrases: Seq[String]): Boolean = phrases.groupBy(identity).values.filter(_.length > 1).toList.length < 1
  }

  object NoAnagramsPassPhraseValidator extends PassPhraseValidator {
    def validate(phrases: Seq[String]): Boolean = phrases.map(_.sorted).groupBy(identity).values.filter(_.length > 1).toList.length < 1
  }

  def parseRows(input: String): Seq[String] = input.split("\\r?\\n")

  def parseRow(rowString: String): Seq[String] = rowString.split("\\s+")

  def findValidRows(rows: Seq[Seq[String]])(implicit validator: PassPhraseValidator): Seq[Seq[String]] = rows.filter(validator.validate)
}

abstract class Solution04 extends Solution(4) {
  implicit val validator: Solution04.PassPhraseValidator

  def solveFor(input: String): Int = {
    val allRows = Solution04.parseRows(input).map(Solution04.parseRow)
    Solution04.findValidRows(allRows).length
  }
}

object Solution04a extends Solution04 {
  implicit val validator = Solution04.UniquePassPhraseValidator
}

object Solution04b extends Solution04 {
  implicit val validator = Solution04.NoAnagramsPassPhraseValidator
}
