package me.gladwell.peachtree.build

import sbt._
import sbt.IO.createDirectory
import Keys._
import me.gladwell.peachtree._

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

      generateSiteTask <<= (siteTitle, peachSourceDirectory, siteDirectory, streams) map {
        (title, source, target, s) => {
          s.log.info("generating site '" + title + "' from [" + source + "]")
          peachtree.siteLoader.load(source)
        }
      },

      addPageTask <<= inputTask { (argTask: TaskKey[Seq[String]]) =>
        (argTask, peachSourceDirectory, siteDirectory, pagesDirectory, siteTitle) map { (args: Seq[String], source, target, pages, title) =>
          createDirectory(pages)
          val page = args(0)
          val title = args.quotedArgs(1)
        }
      }
    )
  )

}
