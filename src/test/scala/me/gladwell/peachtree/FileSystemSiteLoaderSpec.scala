package me.gladwell.peachtree

import java.io.File
import scala.io.Source

import org.mockito.Mockito.when
import org.mockito.Matchers.any
import org.mockito.Matchers.argThat
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.mock.MockitoSugar

class FileSystemSiteLoaderSpec extends FlatSpec with ShouldMatchers with MockitoSugar {

  val pageTemplate = new File("./src/sbt-test/peachtree/simple/src/main/peach/pages/index.mustache")

  trait MockPageModule extends PageModule {
    def validPage(file: File): Boolean = file == pageTemplate
    def pageLoader = {
      val pageLoader = mock[PageLoader]
      when(pageLoader.load(any())) thenReturn page
      pageLoader
    }
    val page: Page = mock[Page]
  }

  private object module extends FileSystemSiteModule with MockPageModule

  "FileSystemSiteLoader" should "recursively find all pages in a folder" in {
    val site =  module.siteLoader.load(new File("./src/sbt-test"))
    site.pages should contain (module.page)
  }

}
