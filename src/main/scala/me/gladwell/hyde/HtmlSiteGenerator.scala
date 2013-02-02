package me.gladwell.hyde

import java.io.File
import scala.xml._
import sbt.IO.createDirectory

class HtmlSiteGenerator extends SiteGenerator {

  def generate(site: Site): Unit = {
    for(page <- site.pages) {
      createDirectory(new File("project/target/hyde/site"))
      XML.save("project/target/hyde/site/" + page.id + ".html",
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
