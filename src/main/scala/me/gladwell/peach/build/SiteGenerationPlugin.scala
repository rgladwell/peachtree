package me.gladwell.peach.build

import sbt._
import sbt.IO.createDirectory
import Keys._
import me.gladwell.peach._
import me.gladwell.peach.pages.JSONPageWriter

object SiteGenerationPlugin extends Plugin {

  val Configuration = config("peach")

  val siteTitle = SettingKey[String]("site-title", "Title of Peach Tree static site.")
  val siteDirectory = SettingKey[File]("site-directory", "Directory for generating Peach Tree static site content.")
  val peachSourceDirectory = SettingKey[File]("site-sources", "Directory for Peach Tree source content files.")
  val pagesDirectory = SettingKey[File]("page-sources", "Directory for Peach Tree page content files.")

  val generateSiteTask = TaskKey[Unit]("generate-site", "generate static Peach Tree site")

  val addPageTask = InputKey[Unit]("add-page", "create new Peach Tree page")

  override lazy val settings = inConfig(Configuration)(
    Seq(
      siteTitle <<= description,

      siteDirectory <<= target.apply(new File(_, "peach/site")),

      peachSourceDirectory <<= sourceDirectory.apply(new File(_, "main/peach")),

      pagesDirectory <<= peachSourceDirectory.apply(new File(_, "pages")),

      generateSiteTask <<= (siteTitle, pagesDirectory, siteDirectory) map { (title, source, target) =>
        println("Generating Peach Tree template site... " + title)
        println("Generating Peach Tree template site in " + target)

        createDirectory(source)
        createDirectory(target)

        val peachTree = PeachTree(source, target)
        def site = peachTree.loadSite(new SiteInfo(title = title))
        peachTree generate site
      },

      addPageTask <<= inputTask { (argTask: TaskKey[Seq[String]]) =>
        (argTask, pagesDirectory, siteDirectory) map { (args: Seq[String], source, target) =>
          createDirectory(source)

          val peachTree = PeachTree(source, target)

          args foreach (page => {
            println("Creating page '" + page + "' in " + source)
            peachTree create page
          })
        }
      }
    )
  )

}
