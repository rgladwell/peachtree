package me.gladwell.peach

import java.io.File

import org.scalatest.matchers.ShouldMatchers
import org.scalatest._

class FileOpsSpec extends FlatSpec with ShouldMatchers {

  "FileOps" should "remove file name extension" in {
    new File("/data/test.txt").nameWithoutExtension() should equal ("test")
  }

  it should "not change file name extension" in {
    new File("/test").nameWithoutExtension() should equal ("test")
  }

}
