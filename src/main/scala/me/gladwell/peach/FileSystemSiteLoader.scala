package me.gladwell.peach

import java.io.File
import scala.io.Source
import dispatch.json.JsonParser
import me.gladwell.peach.pages.JSONPageProtocol._
import sjson.json.JsonSerialization._
import me.gladwell.peach.pages.PageWriter

trait FileSystemSiteLoader extends SiteLoader {
  this: PageWriter =>

  def load(info: SiteInfo, source: File): Site = {
    val pages = for {
      file <- source.listFiles()
      if !file.isDirectory() && file.getName().endsWith(".page")
    } yield file
    new Site(title = info.title, pages = pages.map(loadPage(_)))
  }

  private def loadPage(file: File): Page = {
    println("loading page from " + file)
    frombinary[Page](Source.fromFile(file).mkString.getBytes())
  }

}
