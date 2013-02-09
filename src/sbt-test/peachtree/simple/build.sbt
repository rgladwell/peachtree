import scala.xml._

name := "peachtree-test-blog"

description := "BLOG_TITLE"

organization := "me.gladwell"

organizationName := "Gladwell Consultants Ltd."

TaskKey[Unit]("verify-index-html-title") <<= (Keys.description, target) map ( (description, target) =>
  if((XML.loadFile(target.getAbsolutePath() + "/peach/site/index.html") \\ "html" \ "head" \ "title").text != description)
    error("was expecting index html title to be '%s' but was '%s'" format (description, (XML.loadFile(target.getAbsolutePath() + "/peach/site/index.html") \\ "html" \ "head" \ "title").text))
)

TaskKey[Unit]("verify-index-html-h1") <<= (Keys.description, target) map ( (description, target) =>
  if((XML.loadFile(target.getAbsolutePath() + "/peach/site/index.html") \\ "html" \ "body" \ "h1").text != description)
    error("was expecting index html H1 to be '%s' but was '%s'" format (description, (XML.loadFile(target.getAbsolutePath() + "/peach/site/index.html") \\ "html" \ "body" \ "h1").text))
)
