package me.gladwell.peach

import java.io.File
import me.gladwell.peach.pages.PageLoader

trait FileSystemSiteLoader extends SiteLoader {
  this: PageLoader =>

  def load(info: SiteInfo, source: File): Site = {
    val pages = source.findFiles(_.getName().endsWith(".page"))

    val layouts = source.findFiles(_.getName().endsWith(".mustache")).map { f =>
      f.nameWithoutExtension() -> f
    }

    new Site(title = info.title, pages = pages.map(load(_)), layouts.toMap)
  }

}
