package me.gladwell.peach.pages

import java.io.File

private class FileOps(file: File) {

  def nameWithoutExtension(): String = {
    val filename = file.getName()
    val dotIndex = filename.lastIndexOf('.')
    if(dotIndex == -1) filename
    else filename.substring(0, dotIndex)
  }

}
