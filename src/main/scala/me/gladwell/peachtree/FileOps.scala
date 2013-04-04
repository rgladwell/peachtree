package me.gladwell.peachtree

import java.io.File

class FileOps(file: File) {

  def nameWithoutExtension(): String = {
    val filename = file.getName()
    val dotIndex = filename.lastIndexOf('.')
    if(dotIndex == -1) filename
    else filename.substring(0, dotIndex)
  }

}
