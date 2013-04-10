package me.gladwell.peachtree

import java.io.File

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec

class FolderSpec extends FlatSpec with ShouldMatchers {

  private val thisFile = new File("./src/test/scala/me/gladwell/peachtree/FolderSpec.scala")

  "Folder" should "recursively find all files" in {
    new File("./src/test/").files() should contain (thisFile)
  }

  it should "recursively filter some files" in {
    new File("./src/test/").findFiles((file) => false) should (not contain (thisFile))
  }

  it should "throw error on conversion to non-folder" in {
    evaluating { thisFile.files() } should produce [java.lang.AssertionError]
  }

}
