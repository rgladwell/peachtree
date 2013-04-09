sbtPlugin := true

name := "peachtree"

description := "Scala-based static site generator based on Jekyll"

organization := "me.gladwell"

organizationName := "Gladwell Consultants Ltd."

version := "0.1-SNAPSHOT"

libraryDependencies += "com.propensive" % "rapture-io" % "0.7.2"

libraryDependencies += "com.tristanhunt" %% "knockoff" % "0.8.1"

resolvers += "monkey.org" at "http://monkey.org/~marius/maven"

libraryDependencies += "org.monkey" % "mustache" % "1.0.3"

libraryDependencies += "org.scalatest" %% "scalatest" % "1.9.1" % "test"

libraryDependencies += "org.scalamock" %% "scalamock-scalatest-support" % "2.4" % "test"

ScriptedPlugin.scriptedSettings
