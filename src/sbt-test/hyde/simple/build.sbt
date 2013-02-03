import scala.xml._

name := "hyde-test-blog"

description := "test-blog-description"

organization := "me.gladwell"

organizationName := "Gladwell Consultants Ltd."

TaskKey[Unit]("verify-index-html-title") <<= Keys.description map (description =>
  if((XML.loadFile("project/target/hyde/site/index.html") \\ "html" \ "head" \ "title").text != description)
    error("was expecting index html title to be '%s' but was '%s'" format (description, (XML.loadFile("project/target/hyde/site/index.html") \\ "html" \ "head" \ "title").text))
)

TaskKey[Unit]("verify-index-html-h1") <<= Keys.description map (description =>
  if((XML.loadFile("project/target/hyde/site/index.html") \\ "html" \ "body" \ "h1").text != description)
    error("was expecting index html title to be '%s' but was '%s'" format (description, (XML.loadFile("project/target/hyde/site/index.html") \\ "html" \ "body" \ "h1").text))
)
