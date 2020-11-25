scalaVersion := "2.12.12"

name := "spark"
organization := "ru.dsv27"
version := "1.0"


libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"
libraryDependencies += "org.dsv.spark" % "utils" % "1.0" from "file:///home/dmitrii/sundries/scala/spark-utils/target/scala-2.11/scala-util_2.11-1.0.jar"
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.4.1",
  "org.apache.spark" %% "spark-sql" % "2.4.1"
  )
libraryDependencies += "commons-codec" % "commons-codec" % "1.15"

assemblyMergeStrategy in assembly := {
 case PathList("META-INF", xs @ _*) => MergeStrategy.discard
 case x => MergeStrategy.first
}