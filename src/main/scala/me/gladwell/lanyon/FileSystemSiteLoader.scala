package me.gladwell.lanyon

import java.io.File
import scala.io.Source

import dispatch.json.JsonParser
import me.gladwell.lanyon.pages.JSONPageProtocol._
import sjson.json.JsonSerialization._

private class FileSystemSiteLoader extends SiteLoader[File] {

  def load(info: SiteInfo, source: File): Site = {
    println("loading pages from " + source)
    if(source.listFiles() == null) createNewTemplateSite(info, source)
    else {
      println("loading pages 2 from " + source.listFiles())
      val pages = for {
        file <- source.listFiles()
        if !file.isDirectory() && file.getName().endsWith(".page")
      } yield file
      if(pages.length != 0) new Site(title = info.title, pages = pages.map(loadPage(_)))
      else createNewTemplateSite(info, source)
    }
  }

  private def loadPage(file: File): Page = {
    println("loading page from " + file)
    frombinary[Page](Source.fromFile(file).mkString.getBytes())
  }

  private def createNewTemplateSite(info: SiteInfo, source: File): Site = {
    val site = new Site(title = info.title)
    site.pages.foreach { page => createPage(source, page.id) }
    site
  }
}
