package me.gladwell.hyde.build

import sbt._
import Keys._
import me.gladwell.hyde._

object SiteGenerationPlugin extends Plugin {

  override lazy val settings = Seq(commands += generateSiteCommand)

  lazy val generateSiteCommand : Command =
    Command.command("generate-site") { (state: State) =>
      def title = new SiteSetting(description, state).get()

      println("Generating Hyde template site... " + title.get)

      def site = new Site(title = title.get)
      new HtmlSiteGenerator().generate(site)
      state
    }

}
