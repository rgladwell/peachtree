package me.gladwell.peach

trait SiteLoader[S] {

  def load(info: SiteInfo, source: S): Site

}
