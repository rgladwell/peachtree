package me.gladwell.hyde

import sbt._
import Keys._

object SiteGenerationPlugin extends Plugin {

  override lazy val settings = Seq(commands += generateSiteCommand)

  lazy val generateSiteCommand : Command =
    Command.command("generate-site") { (state: State) =>
      println("Generating Hyde template site...")
      def title = description in Project.extract(state).currentRef get Project.extract(state).structure.data
      new HtmlSiteGenerator().generate(new Site(title = title.get))
      state
    }

}
