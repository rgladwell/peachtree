sbtPlugin := true

name := "hyde"

description := "Scala-based static site generator based on Jekyll"

organization := "me.gladwell"

organizationName := "Gladwell Consultants Ltd."

version := "0.1-SNAPSHOT"

libraryDependencies += "net.debasishg" %% "sjson" % "0.18"

ScriptedPlugin.scriptedSettings
