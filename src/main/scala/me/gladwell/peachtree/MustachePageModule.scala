package me.gladwell.peachtree

import java.io.File

trait MustachePageModule extends PageModule[File] {

  class MustachePage extends Page

  class MustachePageLoader extends PageLoader {
    def load(source: File) = {
      if(source.getName().endsWith(".mustache")) Some(new MustachePage)
      else None
    }
  }

  def pageLoader = new MustachePageLoader

}
