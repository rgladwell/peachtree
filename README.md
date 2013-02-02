Hyde
====

Scala-based static site generator based on Jekyll.

Requirements
------------

* [sbt](https://github.com/harrah/xsbt/wiki) 0.11.x+


Installation
------------

Add the following lines to ~/.sbt/plugins/build.sbt or PROJECT_DIR/project/plugins.sbt

    addSbtPlugin("me.gladwell" % "hyde" % "0.1-SNAPSHOT")

Usage
-----

Use the `generate-site` sbt command to create your static site in the `project/target/hyde/site`
folder.
