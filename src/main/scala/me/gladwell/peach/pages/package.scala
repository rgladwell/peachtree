package me.gladwell.peach

import java.io.File

package object pages {

  private[pages] implicit def augmentFile(file: File) = new FileOps(file)

}
