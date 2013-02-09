package me.gladwell.peach.pages

import me.gladwell.peach.Page
import java.io.File

trait PageWriter {

  def createPage(file: File, page: Page)

}
