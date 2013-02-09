package me.gladwell.lanyon

trait SiteLoader[S] {

  def load(info: SiteInfo, source: S): Site

}
