package me.gladwell.peach.pages

import java.io.File
import scala.io.Source

import spray.json._

private class JSONPage(file: File) extends Page {

  private lazy val json = Source.fromFile(file).mkString.asJson.asJsObject

  lazy val path = file.nameWithoutExtension()

  lazy val title = {
    if(json.fields.contains("title")) new Some[String] (json.fields("title").toString.drop(1).dropRight(1))
    else None
  }

}
