package me.gladwell.peach

import java.io.File
import me.gladwell.peach.pages.PageWriter

trait PeachTree[S] {
  this: SiteGenerator with SiteLoader[S] with PageWriter =>

  def generateSite(output: File, site: Site): Unit = generate(output, site)
  def loadSite(info: SiteInfo, source: S) : Site = load(info, source)
  def createPage(file: File, page: String) = write(file, new Page(id = page))

}
