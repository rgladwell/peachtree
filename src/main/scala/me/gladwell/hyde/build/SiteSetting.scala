package me.gladwell.hyde.build

import sbt._

class SiteSetting[T](key: SettingKey[T], state: State) {

  def get(): Option[T] = {
    def extracted = Project.extract(state)
    key in extracted.currentRef get extracted.structure.data
  }

}
