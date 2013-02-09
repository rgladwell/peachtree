package me.gladwell.lanyon.build

import sbt._
import sbt.IO.createDirectory
import Keys._

import me.gladwell.lanyon._

object SiteGenerationPlugin extends Plugin {

  val Configuration = config("lanyon")

  val siteTitle = SettingKey[String]("site-title", "Title of Lanyon static site.")
  val siteDirectory = SettingKey[File]("site-directory", "Directory for generating Lanyon static site content.")
  val lanyonSourceDirectory = SettingKey[File]("site-sources", "Directory for Lanyon source content files.")
  val pagesDirectory = SettingKey[File]("page-sources", "Directory for Lanyon page content files.")

  val generateSiteTask = TaskKey[Unit]("generate-site", "generate static Lanyon site")

  val addPageTask = InputKey[Unit]("add-page", "create new Lanyon page")

  override lazy val settings = inConfig(Configuration)(
    Seq(
      siteTitle <<= description,

      siteDirectory <<= target.apply(new File(_, "lanyon/site")),

      lanyonSourceDirectory <<= sourceDirectory.apply(new File(_, "main/lanyon")),

      pagesDirectory <<= lanyonSourceDirectory.apply(new File(_, "pages")),

      generateSiteTask <<= (siteTitle, siteDirectory, pagesDirectory) map { (title, output, source) =>
        println("Generating Lanyon template site... " + title)
        println("Generating Lanyon template site in " + output)

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
