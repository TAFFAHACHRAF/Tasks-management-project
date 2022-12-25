package project.tasks_management.dao.task;

import project.tasks_management.dao.Dao;
import project.tasks_management.entities.Task;

import java.util.List;

public interface TaskDAO extends Dao<Task> {
    List<Task> getTasksByResponsable(int responsable_id);
}
