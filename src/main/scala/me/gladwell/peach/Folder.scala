package me.gladwell.peach

import java.io.File

class Folder(folder: File) {

  def findFiles(f: File => Boolean): Seq[File] = {
    def recursiveFindFiles(folder: File, f: File => Boolean): Seq[File] = {
      val files = folder.listFiles
      files.filter(f(_)) ++ files.filter(_.isDirectory).flatMap(recursiveFindFiles(_, f))
    }

     recursiveFindFiles(folder, f)
  }

}