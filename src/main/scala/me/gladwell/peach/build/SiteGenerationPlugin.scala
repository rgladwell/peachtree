package me.gladwell.peach.build

import sbt._
import sbt.IO.createDirectory
import Keys._
import me.gladwell.peach._
import me.gladwell.peach.pages.JSONPageWriter

object SiteGenerationPlugin extends Plugin {

  object peachTree extends PeachTree[File]
                          with HtmlSiteGenerator
                          with FileSystemSiteLoader
                          with JSONPageWriter

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

      generateSiteTask <<= (siteTitle, siteDirectory, pagesDirectory) map { (title, output, source) =>
        println("Generating Peach Tree template site... " + title)
        println("Generating Peach Tree template site in " + output)

        createDirectory(source)
        createDirectory(output)
        def site = peachTree.loadSite(new SiteInfo(title = title), source)
        peachTree.generateSite(output, site)
      },

      addPageTask <<= inputTask { (argTask: TaskKey[Seq[String]]) =>
        (argTask, pagesDirectory) map { (args: Seq[String], output) =>
          createDirectory(output)
          args foreach (page => {
            println("Creating page '" + page + "' in " + output)
            peachTree.createPage(output, page)
          })
        }
      }
    )
  )

}
