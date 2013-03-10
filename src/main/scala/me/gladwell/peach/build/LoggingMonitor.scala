package me.gladwell.peach.build

import java.io.File
import me.gladwell.peach.Monitor

private class LoggingMonitor extends Monitor {

  def writingTo(file: File) = {
    println("Writing content to file=[%s]" format (file))
  }

  def applyingTransform(transform: String) = {
    println("Applying transform=[%s]" format (transform))
  }

}
