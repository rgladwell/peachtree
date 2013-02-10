package me.gladwell.peach.pages

import java.io.File
import scala.io.Source
import scala.xml.Node

import spray.json._

private class JSONPage(file: File, val content: Node) extends Page {

  import JsonProtocol._

  private lazy val json = Source.fromFile(file).mkString.asJson.asJsObject

  lazy val path = file.nameWithoutExtension()

  lazy val title = (content find (_.text.nonEmpty)) map (_.text)

}
