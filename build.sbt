name := "AkkaActorExample"

organization := "com.github.wpm.AkkaActorExample"

version := "1.0.0"

scalaVersion := "2.10.1"

scalacOptions ++= Seq("-unchecked", "-deprecation")

libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.1.4",
    "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test",
    "com.typesafe.akka" %% "akka-testkit" % "2.1.0"
    )
