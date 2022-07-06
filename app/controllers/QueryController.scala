package controllers

import Tsv.Parse._
import Querry.Count._
import Guard.UrlGuard._
import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json.JsNumber
import play.api.libs.json.JsObject
import play.api.libs.json.JsArray
import play.api.libs.json.JsString
import play.api.libs.json.JsBoolean
import play.api.libs.json.JsNull

@Singleton
class QueryController @Inject() (val controllerComponents: ControllerComponents)
    extends BaseController {
  def count(date: String) = Action { implicit request: Request[AnyContent] =>
    val data = fileToIterator
    val guard = dateParamCheck(date)

    guard match {
      case null =>
        Ok(
          JsObject(
            Seq(
              "count" -> JsString(countQueriesWithDate(data, date).toString())
            )
          )
        )
      case _: JsObject => Ok(guard)
    }
  }
}
