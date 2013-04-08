package me.gladwell.peachtree

import java.io.File
import scala.io.Source
import com.github.mustachejava.DefaultMustacheFactory
import java.io.StringReader
import java.io.StringWriter
import java.io.Writer

trait MustachePageModule extends PageModule {

  private val factory = new DefaultMustacheFactory()

  class MustachePage(private val source: Source) extends Page {
    val mustache = factory.compile(new StringReader(source.toString), "temp")
    val writer: Writer = new StringWriter
    val content = {
      mustache.execute(writer, null)
      writer.flush()
      writer.toString
    }
  }

  class MustachePageLoader extends PageLoader {
    def load(source: Source) = new MustachePage(source = source)
  }

  def validPage(file: File): Boolean = file.getName().endsWith(".mustache")

  def pageLoader = new MustachePageLoader

}
