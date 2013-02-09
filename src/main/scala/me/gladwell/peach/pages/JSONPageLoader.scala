package me.gladwell.peach.pages

import java.io.File

trait JSONPageLoader extends PageLoader {

  def load(file: File): Page = {
    println("loading page from " + file)
    return new JSONPage(file)
  }

}
