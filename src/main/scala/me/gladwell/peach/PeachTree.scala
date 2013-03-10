package me.gladwell.peach

import java.io.File

class PeachTree {

}

object PeachTree {
  def apply() (implicit site: SiteInfo) = new PeachTree()
}
