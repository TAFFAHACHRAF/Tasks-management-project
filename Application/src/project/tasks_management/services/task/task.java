package project.tasks_management.services.task;

import project.tasks_management.dao.task.TaskDmpl;
import project.tasks_management.entities.Task;
import project.tasks_management.services.Service;

import java.sql.SQLException;
import java.util.List;

public class task implements Service<Task> {
    static TaskDmpl tmpl;

    @Override
    public void add(Task task) throws SQLException {
        tmpl.save(task);
    }

    @Override
    public void delete(Task task) throws SQLException {
        tmpl.delete(task);
    }

    @Override
    public void update(Task task) throws SQLException {
        tmpl.update(task);
    }

    @Override
    public List<Task> get() throws SQLException {
        return tmpl.findAll();
    }
}
