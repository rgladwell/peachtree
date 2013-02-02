package me.gladwell.hyde

import sbt._
import Keys._

object SiteGenerationPlugin extends Plugin {

  override lazy val settings = Seq(commands += generateSiteCommand)

  lazy val generateSiteCommand =
    Command.command("generate-site") { (state: State) =>
      println("Generating Hyde template site...")
      new HtmlSiteGenerator().generate(new Site(title = "Test"))
      state
    }

}
