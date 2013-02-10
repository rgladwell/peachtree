package me.gladwell.peach.pages

import java.io.File

import com.tristanhunt.knockoff.DefaultDiscounter._
import scala.io.Source
import scala.xml.Node

import me.gladwell.peach._

trait MarkdownPageContentLoader extends PageContentLoader {

  def loadContent(file: File): Node = {
    def markdown = new File(file.getParentFile(), file.nameWithoutExtension() + ".markdown")
    println("loading page content from " + markdown)
    def content = toXHTML(knockoff(Source.fromFile(markdown).mkString))
    println("loading page content=[" + content + "]")
    content
  }

}
