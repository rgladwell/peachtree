package me.gladwell.peach

import java.io.File

trait SiteLoader {

  def load(info: SiteInfo, source: File): Site

}
