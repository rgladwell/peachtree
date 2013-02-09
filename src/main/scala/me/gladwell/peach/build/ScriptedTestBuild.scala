package me.gladwell.peach.build

import java.io.File
import scala.collection.Seq
import scala.xml._

import sbt._
import sbt.Keys._

abstract class ScriptedTestBuild extends Build {

  lazy val root = Project("main", file("."), settings = Defaults.defaultSettings ++ scriptedTestSettings)

  lazy val assertPageTitleTask = InputKey[Unit]("assert-page-title")

  lazy val scriptedTestSettings = Seq(
    assertPageTitleTask <<= inputTask { (argTask: TaskKey[Seq[String]]) =>
        (argTask, target) map { (args: Seq[String], target) => {
          val path = args(0)
          val expected = args(1)
          val file = target.getAbsolutePath() + "/peach/site/" + path + ".html"
          val actualTitle = (XML.loadFile(file) \\ "html" \ "head" \ "title").text

          if(expected != actualTitle) {
            sys.error("was expecting index html title to be '%s' but was '%s' in '%s'" format (expected, actualTitle, file))
          }

          val actualH1 = (XML.loadFile(file) \\ "html" \ "body" \ "h1").text

          if(expected != actualH1) {
            sys.error("was expecting index html header to be '%s' but was '%s' in '%s'" format (expected, actualH1, file))
          }
        }
      }
    }
  )

}
