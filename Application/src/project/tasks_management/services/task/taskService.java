package project.tasks_management.services.task;

import project.tasks_management.entities.*;
import project.tasks_management.entities.Task;
import project.tasks_management.services.Service;

import java.sql.SQLException;
import java.util.List;

public interface taskService extends Service<Task> {
    public List<Task> retournerTasks() throws SQLException;
    public Task retournerTaskParId(Task t) throws SQLException;
    public Task retournerTaskParOrderDeTravail(OrderDeTravail o) throws SQLException;
    public List<Task> retournerTasksParNotification(Notification n) throws SQLException;
    public List<Task> retournerTasksParIntervenant(Intervenant i) throws SQLException;
    public List<Task> retournerTasksParProjet(Projet p) throws SQLException;
    public List<Task> retournerTasksParMateriel(Materiel m) throws SQLException;
    public Materiel affecter_materiel(long t,long m) throws SQLException;
    public Intervenant affecter_intervenant(long t,long i) throws SQLException;
    public boolean supprimer_affectation_intervenant(Task t,Intervenant i) throws SQLException;
    public boolean supprimer_affectation_materiel(Task t,Materiel m) throws SQLException;
    public void ajouterTask(Task t) throws SQLException;

    public void supprimerTask(Task t) throws SQLException;

    public void modifierTask(Task t) throws SQLException;
    public void enregistrerTask(Task t) throws SQLException;

}
