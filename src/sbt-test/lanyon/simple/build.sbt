import scala.xml._

name := "lanyon-test-blog"

description := "test-blog-description"

organization := "me.gladwell"

organizationName := "Gladwell Consultants Ltd."

TaskKey[Unit]("verify-index-html-title") <<= (Keys.description, target) map ( (description, target) =>
  if((XML.loadFile(target.getAbsolutePath() + "/lanyon/site/index.html") \\ "html" \ "head" \ "title").text != description)
    error("was expecting index html title to be '%s' but was '%s'" format (description, (XML.loadFile(target.getAbsolutePath() + "/lanyon/site/index.html") \\ "html" \ "head" \ "title").text))
)

TaskKey[Unit]("verify-index-html-h1") <<= (Keys.description, target) map ( (description, target) =>
  if((XML.loadFile(target.getAbsolutePath() + "/lanyon/site/index.html") \\ "html" \ "body" \ "h1").text != description)
    error("was expecting index html title to be '%s' but was '%s'" format (description, (XML.loadFile(target.getAbsolutePath() + "/lanyon/site/index.html") \\ "html" \ "body" \ "h1").text))
)
