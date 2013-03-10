package me.gladwell.peach

trait Page {

  val layout: String
  val content: String

}

trait Pages {

  def page(path: String): IO[Page]

}
