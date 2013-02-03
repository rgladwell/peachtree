package me.gladwell

import java.io.File

package object hyde {

  val defaultPages = List(new Page(id = "index"))

  private val siteGenerator = new HtmlSiteGenerator()

  def generateSite(output: File, site: Site) = siteGenerator.generate(output, site)

}
