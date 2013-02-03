package me.gladwell.hyde.pages

import me.gladwell.hyde.Page
import java.io.File

trait PageWriter {

  def createPage(file: File, page: Page)

}
