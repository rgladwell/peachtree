package me.gladwell.peachtree

import java.io.File

trait FileSystemSiteModule extends SiteModule[Folder, File] {
  this: PageModule[File] =>

  class MustacheSiteLoader extends SiteLoader[Folder] {
    def load(source: Folder): Site = new Site(pages = source.files().map(pageLoader.load(_)).flatten)
  }

  def siteLoader() = new MustacheSiteLoader

}
