package me.gladwell.peachtree

trait PageModule[T] {

  trait Page

  trait PageLoader {
    def load(source: T): Option[Page]
  }

  def pageLoader: PageLoader

}
