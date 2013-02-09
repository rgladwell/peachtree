Peach Tree
==========

Scala-based static site generator based on Jekyll.

Requirements
------------

* [sbt](https://github.com/harrah/xsbt/wiki) 0.11.x+

Installation
------------

Add the following lines to ~/.sbt/plugins/build.sbt or PROJECT_DIR/project/plugins.sbt

    addSbtPlugin("me.gladwell" % "peachtree" % "0.1-SNAPSHOT")

Usage
-----

Use the `peach:generate-site` sbt command to create your static site in the `project/target/peach/site` folder.

To create a basic page use the `peach:add-page <page>` sbt command as follows:

    > peach:add-page about
    > peach:generate-site

This should create a new `about.page` file in `src/main/peach/pages` and a new `about.html` HTML file
in the project/target/peach/site` folder.
