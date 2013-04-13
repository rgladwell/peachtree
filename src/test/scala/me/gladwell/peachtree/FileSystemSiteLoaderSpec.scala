package me.gladwell.peachtree

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import java.io.File
import scala.io.Source
import org.scalamock.scalatest.MockFactory
import org.scalamock.ProxyMockFactory

class FileSystemSiteLoaderSpec extends FlatSpec with ShouldMatchers with MockFactory with ProxyMockFactory {

  val pageTemplate = new File("./src/sbt-test/peachtree/simple/src/main/peach/pages/index.mustache")

  trait MockPageModule extends PageModule {
    def validPage(file: File): Boolean = file == pageTemplate
    def pageLoader = mock[PageLoader]
    val page: Page = mock[Page]
  }

  private object module extends FileSystemSiteModule with MockPageModule

  "FileSystemSiteLoader" should "recursively find all pages" in {
    module.pageLoader expects 'load withArgs(*) returning (module.page)
    val site =  module.siteLoader.load(new File("./src/sbt-test"))
    site.pages should contain (module.page)
  }

}
