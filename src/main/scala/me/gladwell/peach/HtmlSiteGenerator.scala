package me.gladwell.peach

import java.io.File
import scala.xml._

trait HtmlSiteGenerator extends SiteGenerator {

  def generate(output: File, site: Site): Unit = {
    for(page <- site.pages) {
      def file = new File(output, page.path + ".html")

      val title = page.title match {
        case Some(title) => title
        case None => site.title
      }

      XML.save(file.getAbsolutePath(),
        <html>
          <head>
            <title>{title}</title>
          </head>
          <body>
            <h1>{title}</h1>
          </body>
        </html>
      )
    }
  }

}
