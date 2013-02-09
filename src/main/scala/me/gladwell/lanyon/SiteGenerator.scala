package me.gladwell.lanyon

import java.io.File

private trait SiteGenerator {
  def generate(output: File, site: Site)
}
