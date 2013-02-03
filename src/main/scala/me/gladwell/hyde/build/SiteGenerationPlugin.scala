package me.gladwell.hyde.build

import sbt._
import Keys._
import me.gladwell.hyde._

object SiteGenerationPlugin extends Plugin {

  val Configuration = config("hyde")

  val generateSiteTask = TaskKey[Unit]("generate-site", "generate static Hyde site")

  override lazy val settings = inConfig(Configuration)(
    Seq(
      generateSiteTask <<= (description) map { description => 
        println("Generating Hyde template site... " + description)

        def site = new Site(title = description)
        new HtmlSiteGenerator().generate(site)
      }
    )
  )

}
