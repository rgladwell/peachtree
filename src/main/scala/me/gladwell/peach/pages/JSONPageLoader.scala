package me.gladwell.peach.pages

import java.io.File
import scala.io.Source

import org.apache.commons.io.FilenameUtils.removeExtension
import dispatch.json.JsonParser
import sjson.json.JsonSerialization._

import me.gladwell.peach.pages.JSONPageProtocol._

trait JSONPageLoader extends PageLoader {

  def load(file: File): Page = {
    println("loading page from " + file)
//    val page = frombinary[Page](Source.fromFile(file).mkString.getBytes())
    new Page(path = removeExtension(file.getName()))
  }

}
