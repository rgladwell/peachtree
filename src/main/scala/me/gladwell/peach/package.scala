package me.gladwell

import java.io.File
import me.gladwell.peach.pages.JSONPageWriter

package object peach {

  private val siteGenerator = new HtmlSiteGenerator()
  private val pageWriter = new JSONPageWriter()
  private val siteLoader = new FileSystemSiteLoader()

  def loadSite(info: SiteInfo, source: File) : Site = siteLoader.load(info, source)
  def generateSite(output: File, site: Site) = siteGenerator.generate(output, site)
  def createPage(file: File, page: String) = pageWriter.createPage(file, new Page(id = page))

}
