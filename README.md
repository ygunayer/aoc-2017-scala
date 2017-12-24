# aoc-2017-scala
My solutions for [Advent of Code 2017](http://adventofcode.com/2017), in Scala.

[![Build Status](https://travis-ci.org/ygunayer/aoc-2017-scala.svg?branch=master)](https://travis-ci.org/ygunayer/aoc-2017-scala) [![Coverage Status](https://coveralls.io/repos/github/ygunayer/aoc-2017-scala/badge.svg?branch=master)](https://coveralls.io/github/ygunayer/aoc-2017-scala?branch=master)

## Running
The Advent of Code has two challenges per day for 25 days, so I marked each solution with a two-digit day code and the letters `a` and `b` for the individual parts (e.g. `Solution02a` for the first part of day 2)

Use the following command to run a specific challenge (mind the double quotes)

```
$ sbt "run Solution03b"
```

## Testing
Each solution has tests that use the examples as input. To run all tests, run the following command

```
$ sbt test
```

To run a specific test, launch `sbt` in continuous execution mode, and run the following command (mind the asterisk `*`)

```
> testOnly *Solution03bTests
```

## License
MIT
