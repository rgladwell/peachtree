package me.gladwell.peach

import java.io.File

trait SiteGenerator {
  def generate(output: File, site: Site)
}
