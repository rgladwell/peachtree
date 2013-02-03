package me.gladwell.hyde.pages

import sjson.json.Format
import me.gladwell.hyde.Page
import sjson.json.DefaultProtocol

object JSONPageProtocol extends DefaultProtocol {

  import sjson.json.JsonSerialization._
  import dispatch.json._

  implicit object PageFormat extends Format[Page] {

    def reads(json: JsValue): Page = json match {
      case JsObject(m) => new Page(id = fromjson[String](m(JsString("id"))))
      case _ =>  throw new RuntimeException("JsObject expected")
    }

    def writes(page: Page): JsValue = {
      JsObject(
        Map(
          tojson("id").asInstanceOf[JsString] -> tojson(page.id).asInstanceOf[JsString]
        )
      )
    }

  }

}
