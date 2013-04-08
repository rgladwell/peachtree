package me.gladwell.peachtree

trait SiteModule[T, S] {
  this: PageModule[S] =>

  class Site(val pages: Seq[Page])

  trait SiteLoader[T] {
    def load(source: T): Site
  }

  def siteLoader : SiteLoader[T]

}
