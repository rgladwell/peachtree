package me.gladwell.peach

trait Files {

  def read(path: String): IO[String]

}
