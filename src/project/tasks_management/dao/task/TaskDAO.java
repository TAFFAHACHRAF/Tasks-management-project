package project.tasks_management.dao.task;

import project.tasks_management.dao.Dao;
import project.tasks_management.entities.*;

import java.sql.SQLException;
import java.util.List;

public interface TaskDAO extends Dao<Task> {
    public Task getTaskByOrderDeTravail(OrderDeTravail o);
    public List<Task> getTasksByNotification(Notification n);
    public List<Task> getTasksByIntervenant(Intervenant i);
    public List<Task> getTasksByProjet(Projet p);
    public List<Task> getTasksByMateriel(Materiel m);
    public Materiel affecter_materiel(long tskId,long matId);
    public Intervenant affecter_intervenant(long t,long i);
    public boolean delete_affectation_intervenant(Task t,Intervenant i);
    public boolean delete_affectation_materiel(Task t,Materiel m);
}
