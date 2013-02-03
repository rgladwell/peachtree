package me.gladwell.hyde

trait SiteLoader[S] {

  def load(info: SiteInfo, source: S): Site

}
