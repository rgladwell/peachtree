package me.gladwell.peach.pages

import java.io.File

trait PageLoader {

  def load(file: File): Page

}
