package me.gladwell.lanyon.pages

import me.gladwell.lanyon.Page
import java.io.File

trait PageWriter {

  def createPage(file: File, page: Page)

}
