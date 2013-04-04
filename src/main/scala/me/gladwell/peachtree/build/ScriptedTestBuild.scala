package me.gladwell.peachtree.build

import java.io.File
import scala.collection.Seq
import scala.xml._

import sbt._
import sbt.Keys._

abstract class ScriptedTestBuild extends Build {

  lazy val root = Project("main", file("."), settings = Defaults.defaultSettings ++ scriptedTestSettings)

  lazy val assertPageTitleTask = InputKey[Unit]("assert-page-title")

  lazy val assertPageHeaderTask = InputKey[Unit]("assert-page-header")

  lazy val assertPageDivTask = InputKey[Unit]("assert-page-div")

  lazy val scriptedTestSettings = Seq(
    assertPageTitleTask <<= inputTask { (argTask: TaskKey[Seq[String]]) =>
        (argTask, target) map { (args: Seq[String], target) => {
          val path = args(0)
          val expected = args.quotedArgs(1)
          val file = target.getAbsolutePath() + "/peach/site/" + path + ".html"
          val actualTitle = (XML.loadFile(file) \\ "html" \ "head" \ "title").text

          if(expected != actualTitle) {
            sys.error("was expecting index html title to be '%s' but was '%s' in '%s'" format (expected, actualTitle, file))
          }
        }
      }
    },

    assertPageHeaderTask <<= inputTask { (argTask: TaskKey[Seq[String]]) =>
        (argTask, target) map { (args: Seq[String], target) => {
          val path = args(0)
          val expected = args.quotedArgs(1)
          val file = target.getAbsolutePath() + "/peach/site/" + path + ".html"

          val actualHeader = (XML.loadFile(file) \\ "h1").text

          if(expected != actualHeader) {
            sys.error("was expecting index html header to be '%s' but was '%s' in '%s'" format (expected, actualHeader, file))
          }
        }
      }
    },

    assertPageDivTask <<= inputTask { (argTask: TaskKey[Seq[String]]) =>
        (argTask, target) map { (args: Seq[String], target) => {
          val path = args(0)
          val id = args(1)
          val file = target.getAbsolutePath() + "/peach/site/" + path + ".html"

          val div = (XML.loadFile(file) \\ "div" \ "@id"  find { _.text == id } )

          if(div.isEmpty) {
            sys.error("was expecting div with id '%s'" format (id))
          }
        }
      }
    }
  )

}
