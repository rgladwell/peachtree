package me.gladwell.hyde

import sbt._
import Keys._

object SiteGenerationPlugin extends Plugin {
  override lazy val settings = Seq(commands += createSiteCommand)

  lazy val createSiteCommand =
    Command.command("create-site") { (state: State) =>
      println("Creating Hyde template site")
      state
    }

}
