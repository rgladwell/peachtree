package me.gladwell.peach.layout

import java.io.File
import me.gladwell.peach.pages.Page
import me.gladwell.peach.Site

trait Styler {

  def style(layout: File, page: Page, site: Site): String

}
