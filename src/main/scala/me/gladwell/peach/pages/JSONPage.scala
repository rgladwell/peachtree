package me.gladwell.peach.pages

import java.io.File

private class JSONPage(file: File) extends Page {

  val path = file.nameWithoutExtension()

}
