package me.gladwell.peach

import java.io.File
import me.gladwell.peach.layout.Styler
import java.io.FileWriter

trait HtmlSiteGenerator extends SiteGenerator {
  this: Styler =>

  def generate(output: File, site: Site): Unit = {
    for(page <- site.pages) {
      def file = new File(output, page.path + ".html")

      val layout = site.layouts(page.layout)
      val writer = new FileWriter(file)
      val styled = style(layout, page, site)
      println("styled content = " + styled)
      writer.write(styled)
      writer.close()
    }
  }

}
