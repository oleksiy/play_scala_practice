package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    val time = new java.util.Date();
    val names = List("James", "Oliver", "PopEye", "Gordon", "Nathan")
    val names2 = List.empty
    Ok(views.html.index("Hello, again, world - passed from Controller <small>SMALL FONT</small>", names2, time.toString))
  }

  def another = Action { implicit request =>
    val initialValue = request.session.get("counter").map(_.toInt).getOrElse(0)
    Ok(views.html.another()).withSession(
      "counter" -> (initialValue + 1).toString
    )
  }

}