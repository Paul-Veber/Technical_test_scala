import play.api.libs.json._

package Guard {
  object UrlGuard {
    def dateParamCheck(dateParam: String): JsObject = {
        val regexp = """^\d{4}-?\d{0,2}-?\d{0,2} ?(?:\d{2}:\d{2})?$""".r
        val errorMsg = "date format is wrong"

        return regexp.findFirstMatchIn(dateParam) match {
            case  Some(_)=> null
            case  None => JsObject(Seq("error" -> JsString(errorMsg)))
        }
    }
  }
}
