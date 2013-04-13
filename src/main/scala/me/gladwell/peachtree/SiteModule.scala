package me.gladwell.peachtree

trait SiteModule[T] {
  this: PageModule =>

  class Site(val pages: List[Page])

  trait SiteLoader[T] {
    def load(source: T): Site
  }

  def siteLoader : SiteLoader[T]

}
