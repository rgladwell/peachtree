package me.gladwell.peachtree

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import scala.io.BufferedSource
import java.io.StringBufferInputStream

class MustachePageLoaderSpec extends FlatSpec with ShouldMatchers {

  val template = """
---
layout: test-layout
---
test-content"""

  val templateWithoutFrontmatter = "test-content"


  object module extends MustachePageModule

  it should "parse content" in {
    val source = new BufferedSource(new StringBufferInputStream(template))
    module.pageLoader.load(source).content should equal ("test-content")
  }

  it should "read layout from YAML front matter" in {
    val source = new BufferedSource(new StringBufferInputStream(template))
    module.pageLoader.load(source).layout should equal (Some("test-layout"))
  }

  it should "read parse content without frontmatter" in {
    val source = new BufferedSource(new StringBufferInputStream(templateWithoutFrontmatter))
    module.pageLoader.load(source).content should equal ("test-content")
  }

  it should "not read layout without YAML front matter" in {
    val source = new BufferedSource(new StringBufferInputStream(templateWithoutFrontmatter))
    module.pageLoader.load(source).layout should equal (None)
  }

}
