package me.gladwell.peachtree

import java.io.File
import scala.io.Source

trait PageModule {

  trait Page {
    val content: String
  }

  trait PageLoader {
    def load(source: Source): Page
  }

  def validPage(file: File): Boolean

  def pageLoader: PageLoader

}
