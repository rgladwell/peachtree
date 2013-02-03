package me.gladwell.hyde.pages

import java.io.File
import java.io.FileWriter

import me.gladwell.hyde.Page
import sjson.json.Writes
import sjson.json.JsonSerialization._
import dispatch.json._

import JSONPageProtocol._

class JSONPageWriter extends PageWriter {

  def createPage(outputDirectory: File, page: Page): Unit = {
    val json = tojson[Page](page)
    val pageFile = new File(outputDirectory, page.id + ".page")
    println("writing page to " + pageFile)
    val writer = new FileWriter(pageFile)
    writer.write(json.toString)
    writer.close()
  }

}
