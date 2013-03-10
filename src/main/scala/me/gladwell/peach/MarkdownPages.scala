package me.gladwell.peach

import com.tristanhunt.knockoff.DefaultDiscounter._
import com.tristanhunt.knockoff._

class MarkdownPage(markdown: String) extends Page {
  private val blocks = knockoff( markdown )
  private val headers = blocks.filter(_.isInstanceOf[Header])

  val layout = null
  val content = toXHTML(blocks).toString
}

trait MarkdownPages extends Pages {
  this: Files =>

  def page(path: String): IO[Page] = {
    (monitor: Monitor) => {
      monitor.applyingTransform("markdown")
      new MarkdownPage(read(path + ".markdown") (monitor))
    }
  }

}
