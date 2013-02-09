package me.gladwell.peach

import java.io.File
import me.gladwell.peach.pages.PageWriter
import me.gladwell.peach.pages.JSONPageWriter

class PeachTree(source: File, target: File) {
  this: SiteGenerator with SiteLoader with PageWriter =>

  def generate(info: SiteInfo): Unit = {
    val site = load(info, source)
    generate(target, site)
  }

  def create(page: String) = write(source, new Page(id = page))

}

object PeachTree {
  def apply(source: File, target: File) = new PeachTree(source, target)
                                                  with HtmlSiteGenerator
                                                  with FileSystemSiteLoader
                                                  with JSONPageWriter
}
