package me.gladwell.peach

import java.io.File

private trait SiteGenerator {
  def generate(output: File, site: Site)
}
