package me.gladwell.peach.pages

import java.io.File

trait PageWriter {

  def write(file: File, page: Page)

}
