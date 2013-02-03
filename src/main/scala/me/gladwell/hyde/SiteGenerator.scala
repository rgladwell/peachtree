package me.gladwell.hyde

import java.io.File

private trait SiteGenerator {
  def generate(output: File, site: Site)
}
