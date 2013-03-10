package me.gladwell

import java.io.File

package object peach {

  type IO[T] = Monitor => T

  protected[peach] implicit def augmentFile(file: File) = new FileOps(file)

  private[peach] implicit def fileToFolder(file: File) = new Folder(file)

}