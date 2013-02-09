package me.gladwell.peach.pages

import java.io.File
import java.io.FileWriter

import spray.json._

object JsonProtocol extends DefaultJsonProtocol {
}

trait JSONPageWriter extends PageWriter {

  import JsonProtocol._

  def write(outputDirectory: File, path: String): Unit = {
    val json = Map[String, String]().toJson
    val pageFile = new File(outputDirectory, path + ".page")
    println("writing page to " + pageFile)
    val writer = new FileWriter(pageFile)
    writer.write(json.toString)
    writer.close()
  }

}
