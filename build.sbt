name := "AkkaToy"

organization := "com.github.wpm.AkkaToy"

version := "1.0.0"

scalaVersion := "2.10.1"

scalacOptions ++= Seq("-unchecked", "-deprecation")

libraryDependencies ++= Seq("com.typesafe.akka" %% "akka-actor" % "2.1.4")
