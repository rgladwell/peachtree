package me.gladwell.peach

import java.io.File

trait Monitor {

  def writingTo(file: File): Unit

  def applyingTransform(transform: String): Unit

}