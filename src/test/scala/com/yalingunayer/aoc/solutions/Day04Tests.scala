package com.yalingunayer.aoc.solutions

import org.scalatest._
import org.scalatest.FlatSpec

class Solution04ParserTests extends FlatSpec with Matchers {
  "parseRows" should "parse rows correctly" in {
    val input = """a b c
d e f"""

    val expected = List("a b c", "d e f")
    val result = Solution04.parseRows(input)

    result should be(expected)
  }

  "parseRow" should "parse plain row correctly" in {
    val input = """a b c"""

    val expected = List("a", "b", "c")
    val result = Solution04.parseRow(input)

    result should be(expected)
  }

  "parseRow" should "parse badly formatted row correctly" in {
    val input = """a                        b    c"""

    val expected = List("a", "b", "c")
    val result = Solution04.parseRow(input)

    result should be(expected)
  }
}

class Solution04ValidatorTests extends FlatSpec with Matchers {
  "uniqueness validator" should "validate input with all uniques" in {
    val input = List("a", "b", "c")

    val result = Solution04.UniquePassPhraseValidator.validate(input)

    result should be(true)
  }

  "uniqueness validator" should "not validate input with duplicates" in {
    val input = List("a", "b", "c", "a")

    val result = Solution04.UniquePassPhraseValidator.validate(input)

    result should be(false)
  }

  "no anagrams validator" should "validate input with no anagrams" in {
    val input = List("a", "b", "c")

    val result = Solution04.NoAnagramsPassPhraseValidator.validate(input)

    result should be(true)
  }

  "uniqueness validator" should "not validate input with anagrams" in {
    val input = List("ab", "ba", "cc", "ac")

    val result = Solution04.NoAnagramsPassPhraseValidator.validate(input)

    result should be(false)
  }
}

class Solution04aTests extends BaseExpectationTest {
  val solver = Solution04a

  val expectations = Map(
    "aa bb cc dd aa" -> 0,
    "aa bb cc dd aaa" -> 1,
    "aa bb cc dd aa bb" -> 0,
    """aa bb cc dd aa bb
xx yy xx""" -> 0)

  define
}

class Solution04bTests extends BaseExpectationTest {
  val solver = Solution04b

  val expectations = Map(
    "abcde fghij" -> 1,
    "a ab abc abd abf abj" -> 1,
    "iiii oiii ooii oooi oooo" -> 1,
    "oiii ioii iioi iiio" -> 0)

  define
}
