name := "problem_10"

version := "1.0"

scalaVersion := "2.9.1"

mainClass := Some("euler.Main")

fork in run := true

javaOptions in run += "-Xss500m"
