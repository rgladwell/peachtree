package me.gladwell.peach.pages

import java.io.File
import scala.io.Source

import spray.json._

private class JSONPage(file: File) extends Page {

  import JsonProtocol._

  private lazy val json = Source.fromFile(file).mkString.asJson.asJsObject

  lazy val path = file.nameWithoutExtension()

  lazy val title = {
    if(json.fields.contains("title")) json.fields("title").convertTo[Option[String]]
    else None
  }

}
