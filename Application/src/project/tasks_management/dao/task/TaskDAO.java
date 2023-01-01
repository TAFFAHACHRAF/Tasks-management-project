package project.tasks_management.dao.task;

import project.tasks_management.dao.Dao;
import project.tasks_management.entities.*;

import java.util.List;

public interface TaskDAO extends Dao<Task> {
    public Task getTaskByOrderDeTravail(OrderDeTravail o);
    public List<Task> getTasksByNotification(Notification n);
    public List<Task> getTasksByIntervenant(Intervenant i);
    public List<Task> getTasksByProjet(Projet p);
    public List<Task> getTasksByMateriel(Materiel m);
}
