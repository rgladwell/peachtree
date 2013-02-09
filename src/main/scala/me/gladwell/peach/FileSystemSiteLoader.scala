package me.gladwell.peach

import java.io.File
import me.gladwell.peach.pages.PageLoader

trait FileSystemSiteLoader extends SiteLoader {
  this: PageLoader =>

  def load(info: SiteInfo, source: File): Site = {
    val pages = for {
      file <- source.listFiles()
      if !file.isDirectory() && file.getName().endsWith(".page")
    } yield file
    new Site(title = info.title, pages = pages.map(load(_)))
  }

}
