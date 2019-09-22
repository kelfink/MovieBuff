name := "MovieBuff"

version := "0.1"

scalaVersion := "2.12.10"

val sparkVersion = "2.4.4"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.8"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"
//


libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion

libraryDependencies += "org.apache.spark" %%   "spark-sql" % sparkVersion
