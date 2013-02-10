package me.gladwell.peach.pages

import java.io.File
import java.io.FileWriter

import spray.json._

trait JSONPageWriter extends PageWriter {

  import JsonProtocol._

  def write(outputDirectory: File, path: String, title: String): Unit = {
    val json = Map("title" -> title, "layout" -> "default").toJson
    val pageFile = new File(outputDirectory + "/pages", path + ".page")
    println("writing page to " + pageFile)
    val writer = new FileWriter(pageFile)
    writer.write(json.prettyPrint)
    writer.close()

    val contentFile = new File(outputDirectory + "/pages", path + ".markdown")
    println("writing page to " + contentFile)
    val contentWriter = new FileWriter(contentFile)
    contentWriter.write("# " + title + "\n")
    contentWriter.close()
  }

}
