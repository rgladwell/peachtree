package me.gladwell.peach

import me.gladwell.peach.pages.Page
import java.io.File

class Site(val title: String, val pages: Seq[Page], val layouts: Map[String, File]) {

}
