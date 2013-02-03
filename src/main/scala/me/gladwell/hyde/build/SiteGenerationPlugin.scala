package me.gladwell.hyde.build

import sbt._
import sbt.IO.createDirectory
import Keys._
import me.gladwell.hyde._

object SiteGenerationPlugin extends Plugin {

  val Configuration = config("hyde")

  val siteDirectory = SettingKey[File]("site-directory")

  val generateSiteTask = TaskKey[Unit]("generate-site", "generate static Hyde site")

  override lazy val settings = inConfig(Configuration)(
    Seq(
      siteDirectory <<= target.apply(new File(_, "hyde/site")),

      generateSiteTask <<= (description, siteDirectory) map { (title, output) =>
        println("Generating Hyde template site... " + title) 
        println("Generating Hyde template site in " + output)

        createDirectory(output)
        def site = new Site(title = title)
        new HtmlSiteGenerator().generate(output, site)
      }
    )
  )

}
