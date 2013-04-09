package me.gladwell.peachtree

import java.io.File
import scala.io.Source

trait PageModule {

  trait Page {
    def content: String
    def layout: Option[String]
  }

  trait PageLoader {
    def load(source: Source): Page
  }

  def validPage(file: File): Boolean

  def pageLoader: PageLoader

}
