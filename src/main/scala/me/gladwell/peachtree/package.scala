package me.gladwell

import java.io.File

package object peachtree {

  private[peachtree] implicit def augmentFile(file: File) = new FileOps(file)

  private[peachtree] implicit def fileToFolder(file: File) = new Folder(file)

}