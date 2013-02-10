package me.gladwell.peach.pages

import java.io.File

trait JSONPageLoader extends PageLoader {
  this: PageContentLoader =>

  def load(file: File): Page = {
    println("loading page from " + file)
    val content = loadContent(file)
    return new JSONPage(file, content)
  }

}
