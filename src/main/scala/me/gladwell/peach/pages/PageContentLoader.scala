package me.gladwell.peach.pages

import java.io.File
import scala.xml.Node

trait PageContentLoader {

  def loadContent(file: File): Node

}