package project.tasks_management.services.task;

import project.tasks_management.dao.task.TaskDmpl;
import project.tasks_management.entities.*;
import project.tasks_management.services.Service;

import java.sql.SQLException;
import java.util.List;

public class task implements taskService {
    TaskDmpl tmpl=new TaskDmpl();


    @Override
    public List<Task> retournerTasks() throws SQLException {
        return tmpl.findAll();
    }

    @Override
    public Task retournerTaskParId(Task t) throws SQLException {
        return tmpl.findOne(t.getID());
    }

    @Override
    public Task retournerTaskParOrderDeTravail(OrderDeTravail o){
        return tmpl.getTaskByOrderDeTravail(o);
    }

    @Override
    public List<Task> retournerTasksParNotification(Notification n){
        return tmpl.getTasksByNotification(n);
    }

    @Override
    public List<Task> retournerTasksParIntervenant(Intervenant i){
        return tmpl.getTasksByIntervenant(i);
    }

    @Override
    public List<Task> retournerTasksParProjet(Projet p){
        return tmpl.getTasksByProjet(p);
    }

    @Override
    public List<Task> retournerTasksParMateriel(Materiel m){
        return tmpl.getTasksByMateriel(m);
    }

    @Override
    public Materiel affecter_materiel(long t,long m){
        return tmpl.affecter_materiel(t,m);
    }

    @Override
    public Intervenant affecter_intervenant(long t,long i){
        return tmpl.affecter_intervenant(t,i);
    }

    @Override
    public boolean supprimer_affectation_intervenant(Task t,Intervenant i){
        return tmpl.delete_affectation_intervenant(t,i);
    }

    @Override
    public boolean supprimer_affectation_materiel(Task t,Materiel m){
        return tmpl.delete_affectation_materiel(t,m);
    }

    @Override
    public void ajouterTask(Task t) throws SQLException {
        tmpl.save(t);
    }

    @Override
    public void supprimerTask(Task t) throws SQLException {
        tmpl.delete(t);
    }

    @Override
    public void modifierTask(Task t) throws SQLException {
        tmpl.update(t);
    }

    @Override
    public void enregistrerTask(Task t) throws SQLException {
        tmpl.save(t);
    }
}
