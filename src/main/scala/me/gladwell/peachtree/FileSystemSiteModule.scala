package me.gladwell.peachtree

import java.io.File
import scala.io.Source

trait FileSystemSiteModule extends SiteModule[Folder] {
  this: PageModule =>

  class MustacheSiteLoader extends SiteLoader[Folder] {

    def load(source: Folder): Site = new Site(pages = findPages(source).toList)

    private def findPages(source: Folder) = {
      val result = for (
        file <- source.files() if validPage(file)
      ) yield pageLoader.load(Source.fromFile(file))
      println (pageLoader.load(Source.fromFile( new File("./src/sbt-test/peachtree/simple/src/main/peach/pages/index.mustache"))))
      println (result)
      result
    }
  }

  def siteLoader = new MustacheSiteLoader

}
