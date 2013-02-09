Lanyon
======

Scala-based static site generator based on Jekyll.

Requirements
------------

* [sbt](https://github.com/harrah/xsbt/wiki) 0.11.x+

Installation
------------

Add the following lines to ~/.sbt/plugins/build.sbt or PROJECT_DIR/project/plugins.sbt

    addSbtPlugin("me.gladwell" % "lanyon" % "0.1-SNAPSHOT")

Usage
-----

Use the `lanyon:generate-site` sbt command to create your static site in the `project/target/lanyon/site` folder.

To create a basic page use the `lanyon:add-page <page>` sbt command as follows:

    > lanyon:add-page about
    > lanyon:generate-site

This should create a new `about.page` file in `src/main/lanyon/pages` and a new `about.html` HTML file
in the project/target/lanyon/site` folder.
