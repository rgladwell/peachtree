package me.gladwell.peach

import java.io.File
import me.gladwell.peach.pages.PageWriter

class PeachTree(source: File, target: File) {
  this: SiteGenerator with SiteLoader with PageWriter =>

  def generate(site: Site): Unit = generate(target, site)
  def loadSite(info: SiteInfo) : Site = load(info, source)
  def create(page: String) = write(source, new Page(id = page))

}
