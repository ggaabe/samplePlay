package controllers

import play.api.mvc._
import play.twirl.api.Html
import models.Task

object Application extends Controller {

  def index = Action {
  val content = Html("<div>This is the content for the sample app</div>")
    Ok(views.html.main("Home")(content))
  }

  def about = Action {
    Ok(views.html.about("About"))
  }

}

object TaskController extends Controller{
  def index = Action{
    Redirect(routes.TaskController.tasks)
  }

  def tasks = Action {
    Ok(views.html.index(Task.all))
  }

  def newTask = Action(parse.urlFormEncoded){
    implicit request =>
      Task.add(request.body.get("taskName").get.head)
      Redirect(routes.TaskController.index)
  }

  def deleteTask(id: Int) = Action{
    Task.delete(id)
    Ok
  }

}
