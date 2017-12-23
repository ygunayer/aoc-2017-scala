name := "aoc-2017-scala"

version := "1.0"

scalaVersion := "2.11.6"

lazy val scalaTestVersion = "2.2.4"

libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-reflect" % scalaVersion.value,
    "org.scalatest" %% "scalatest" % scalaTestVersion % "test"
)
