package me.gladwell.peachtree

import java.io.File

class Folder(folder: File) {

  assert(folder.isDirectory())

  def files(): Seq[File] = {
    def recursiveFiles(folder: File): Seq[File] = {
      val files = folder.listFiles
      files ++ files.filter(_.isDirectory).flatMap(recursiveFiles(_))
    }

     recursiveFiles(folder)
  }

  def findFiles(f: File => Boolean): Seq[File] = {
    def recursiveFindFiles(folder: File, f: File => Boolean): Seq[File] = {
      val files = folder.listFiles
      files.filter(f(_)) ++ files.filter(_.isDirectory).flatMap(recursiveFindFiles(_, f))
    }

     recursiveFindFiles(folder, f)
  }

}
