package me.gladwell.peach.layout

import java.io.File
import com.github.mustachejava.MustacheFactory
import com.github.mustachejava.DefaultMustacheFactory
import java.io.FileReader
import java.io.StringWriter
import scala.io.Source
import java.io.StringReader
import me.gladwell.peach._
import java.util.HashMap
import me.gladwell.peach.pages.Page

trait MustacheStyler extends Styler {

  private def mf = new DefaultMustacheFactory()

  def style(layout: File, page: Page, site: Site): String = {
    val template = Source.fromFile(layout).mkString
    val mustache = mf.compile(new FileReader(layout), layout.nameWithoutExtension)

    val scopes = new HashMap[String, Object]()
    scopes.put("page", page)
    scopes.put("site", site)

    val writer = new StringWriter()
    mustache.execute(writer, scopes)
    writer.flush()
    writer.toString()
  }

}