package me.gladwell.hyde.build

import sbt._
import sbt.IO.createDirectory
import Keys._
import me.gladwell.hyde._

object SiteGenerationPlugin extends Plugin {

  val Configuration = config("hyde")

  val siteTitle = SettingKey[String]("site-title", "Title of Hyde static site.")
  val siteDirectory = SettingKey[File]("site-directory", "Directory for generating Hyde static site content.")
  val hydeSourceDirectory = SettingKey[File]("site-sources", "Directory for Hyde source content files.")
  val pagesDirectory = SettingKey[File]("page-sources", "Directory for Hyde page content files.")

  val generateSiteTask = TaskKey[Unit]("generate-site", "generate static Hyde site")

  val addPageTask = InputKey[Unit]("add-page", "create new Hyde page")

  override lazy val settings = inConfig(Configuration)(
    Seq(
      siteTitle <<= description,

      siteDirectory <<= target.apply(new File(_, "hyde/site")),

      hydeSourceDirectory <<= sourceDirectory.apply(new File(_, "main/hyde")),

      pagesDirectory <<= hydeSourceDirectory.apply(new File(_, "pages")),

      generateSiteTask <<= (siteTitle, siteDirectory, pagesDirectory) map { (title, output, source) =>
        println("Generating Hyde template site... " + title)
        println("Generating Hyde template site in " + output)

        createDirectory(source)
        createDirectory(output)
        def site = loadSite(new SiteInfo(title = title), source)
        generateSite(output, site)
      },

      addPageTask <<= inputTask { (argTask: TaskKey[Seq[String]]) =>
        (argTask, pagesDirectory) map { (args: Seq[String], output) =>
          createDirectory(output)
          args foreach (page => {
            println("Creating page '" + page + "' in " + output)
            createPage(output, page)
          })
        }
      }
    )
  )

}
