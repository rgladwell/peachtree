package me.gladwell.peach.pages

import scala.xml.Node

trait Page {

  val path: String
  val title: Option[String]
  val content: Node

}
