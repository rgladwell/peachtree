sbtPlugin := true

name := "peachtree"

description := "Scala-based static site generator based on Jekyll"

organization := "me.gladwell"

organizationName := "Gladwell Consultants Ltd."

version := "0.1-SNAPSHOT"

resolvers += "spray.io" at "http://repo.spray.io/"

libraryDependencies += "io.spray" % "spray-json_2.9.2" % "1.2.3"

libraryDependencies += "com.tristanhunt" %% "knockoff" % "0.8.1"

libraryDependencies += "com.github.spullara.mustache.java" % "compiler" % "0.8.9"

libraryDependencies += "org.scalatest" %% "scalatest" % "1.9.1" % "test"

ScriptedPlugin.scriptedSettings
