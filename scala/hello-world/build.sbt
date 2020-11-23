
scalaVersion := "2.12.12"
name := "hello-world"
organization := "ru.dsv27.scala"
version := "1.0"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.4.1",
  "org.apache.spark" %% "spark-sql" % "2.4.1"
)
