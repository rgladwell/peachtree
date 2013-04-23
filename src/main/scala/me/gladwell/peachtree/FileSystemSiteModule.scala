package me.gladwell.peachtree

import java.io.File
import scala.io.Source

trait FileSystemSiteModule extends SiteModule[Folder] {
  this: PageModule =>

  class MustacheSiteLoader extends SiteLoader[Folder] {

    def load(source: Folder): Site = new Site(pages = findPages(source).toList)

    private def findPages(source: Folder) = {
      for (
        file <- source.files() if validPage(file)
      ) yield pageLoader.load(Source.fromFile(file))
    }
  }

  def siteLoader = new MustacheSiteLoader

}
