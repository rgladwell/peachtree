package me.gladwell.peach.pages

import java.io.File
import scala.io.Source
import scala.xml.Node

import spray.json._

import me.gladwell.peach._

private class JSONPage(file: File, val xml: Node) extends Page {

  import JsonProtocol._

  private lazy val json = Source.fromFile(file).mkString.asJson.asJsObject

  lazy val path = file.nameWithoutExtension()

  lazy val title = {
    if(json.fields.contains("title")) json.fields("title").convertTo[String]
    else null
  }

  lazy val layout = json.fields("layout").convertTo[String]

  lazy val content = xml.toString

}
