package me.gladwell.hyde.build

import sbt._
import sbt.IO.createDirectory
import Keys._
import me.gladwell.hyde._

object SiteGenerationPlugin extends Plugin {

  val Configuration = config("hyde")

  val siteTitle = SettingKey[String]("site-title", "Title of static site.")
  val siteDirectory = SettingKey[File]("site-directory", "Directory for generating static site content.")

  val generateSiteTask = TaskKey[Unit]("generate-site", "generate static Hyde site")

  override lazy val settings = inConfig(Configuration)(
    Seq(
      siteTitle <<= description,

      siteDirectory <<= target.apply(new File(_, "hyde/site")),

      generateSiteTask <<= (siteTitle, siteDirectory) map { (title, output) =>
        println("Generating Hyde template site... " + title) 
        println("Generating Hyde template site in " + output)

        createDirectory(output)
        def site = new Site(title = title)
        new HtmlSiteGenerator().generate(output, site)
      }
    )
  )

}
