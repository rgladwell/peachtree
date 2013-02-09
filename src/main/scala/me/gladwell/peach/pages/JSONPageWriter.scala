package me.gladwell.peach.pages

import java.io.File
import java.io.FileWriter

import me.gladwell.peach.Page
import sjson.json.Writes
import sjson.json.JsonSerialization._
import dispatch.json._

import JSONPageProtocol._

trait JSONPageWriter extends PageWriter {

  def write(outputDirectory: File, page: Page): Unit = {
    val json = tojson[Page](page)
    val pageFile = new File(outputDirectory, page.id + ".page")
    println("writing page to " + pageFile)
    val writer = new FileWriter(pageFile)
    writer.write(json.toString)
    writer.close()
  }

}
