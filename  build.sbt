sbtPlugin := true

name := "peachtree"

description := "Scala-based static site generator based on Jekyll"

organization := "me.gladwell"

organizationName := "Gladwell Consultants Ltd."

version := "0.1-SNAPSHOT"

resolvers += "spray.io" at "http://repo.spray.io/"

libraryDependencies += "io.spray" % "spray-json_2.9.2" % "1.2.3"

ScriptedPlugin.scriptedSettings
