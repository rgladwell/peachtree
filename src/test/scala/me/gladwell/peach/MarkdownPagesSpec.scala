package me.gladwell.peach

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalamock.scalatest.MockFactory
import org.scalamock.ProxyMockFactory

class MarkdownPagesSpec extends FlatSpec with ShouldMatchers with MockFactory with ProxyMockFactory {

  private val monitor = mock[Monitor]

  private trait MockFiles extends Files {
    def read(path: String): IO[String] = {
      monitor => {
"""
# test
"""
      }
      
    }
  }

  private object pages extends MarkdownPages with MockFiles

  "MarkdownPages" should "parse content" in {
    monitor expects 'applyingTransform withArgs (*)
    pages.page("index")(monitor).content should equal ("<h1>test</h1>")
  }

  it should "monitor applying template of type 'markdown'" in {
    monitor expects 'applyingTransform withArgs ("markdown")
    pages.page("index")(monitor)
  }
}