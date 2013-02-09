package me.gladwell.peach

import java.io.File
import scala.xml._

trait HtmlSiteGenerator extends SiteGenerator {

  def generate(output: File, site: Site): Unit = {
    for(page <- site.pages) {
      def file = new File(output, page.id + ".html")
      XML.save(file.getAbsolutePath(),
        <html>
          <head>
            <title>{site.title}</title>
          </head>
          <body>
            <h1>{site.title}</h1>
          </body>
        </html>
      )
    }
  }

}