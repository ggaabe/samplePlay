package models

case class Task(id: Int, name: String)

object Task{
private var taskList: List[Task] = List()

  def all: List[Task] = {taskList}

  def add(taskName: String) = {
      //val newId: Option[Int] = Some(taskList.last.id + 1)
      Option(taskList.last.id) match{
        case Some(_)   =>  taskList = taskList ++ List(Task(taskList.last.id + 1, taskName))
        case None      =>  taskList = taskList ++ List(Task(0, taskName))
      }
      taskList = taskList ++ List(Task(Some(taskList.last.id + 1).getOrElse(0), taskName))

  }

  def delete(taskId: Int) = {
    taskList = taskList.filterNot(task => task.id == taskId)
  }

}
