import play.api.libs.json._

package Home {
  object Welcome {
    def welcomeMessage: JsValue = Json.parse("""
    {
    "message": "Welcome"
    }
    """)
  }
}
