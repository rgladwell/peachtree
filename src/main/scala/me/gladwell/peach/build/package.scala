package me.gladwell.peach

package object build {

  private[build] implicit def augmentArguments(args: Seq[String]) = new Arguments(args)

}
