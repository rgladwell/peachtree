package me.gladwell.peach.build

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers

class ArgumentsSpec extends FlatSpec with ShouldMatchers {

  "Arguments" should "parse quoted arguments as single argument" in {
    val arguments = Seq("\"arg1", "arg2\"")
    arguments.quotedArgs should equal (Seq("arg1 arg2"))
  }

  it should "not parse un-quoted arguments" in {
    val arguments = Seq("arg0", "arg1")
    arguments.quotedArgs should equal (Seq("arg0", "arg1"))
  }

  it should "parse multiple arguments" in {
    val arguments = Seq("\"arg1", "arg2\"", "arg3", "\"arg4", "arg5\"")
    arguments.quotedArgs should equal (Seq("arg1 arg2", "arg3", "arg4 arg5"))
  }

  it should "ignore unclosed quotes" in {
    val arguments = Seq("\"arg1", "arg2")
    arguments.quotedArgs should equal (Seq("\"arg1", "arg2"))
  }

}
