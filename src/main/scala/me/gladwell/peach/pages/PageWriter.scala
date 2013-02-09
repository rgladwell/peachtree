package me.gladwell.peach.pages

import me.gladwell.peach.Page
import java.io.File

trait PageWriter {

  def write(file: File, page: Page)

}
