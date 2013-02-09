package me.gladwell.peach.pages

import sjson.json.DefaultProtocol
import sjson.json.Writes

private object JSONPageProtocol extends DefaultProtocol {

  import sjson.json.JsonSerialization._
  import dispatch.json._

  implicit object PageFormat extends Writes[Page] {

//    def reads(json: JsValue): Page = json match {
//      case JsObject(m) => new Page(id = fromjson[String](m(JsString("id"))))
//      case _ =>  throw new RuntimeException("JsObject expected")
//    }

    def writes(page: Page): JsValue = {
      JsObject(
        Map(
          tojson("path").asInstanceOf[JsString] -> tojson(page.path).asInstanceOf[JsString]
        )
      )
    }

  }

}
