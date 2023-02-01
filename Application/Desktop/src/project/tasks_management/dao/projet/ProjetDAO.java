package project.tasks_management.dao.projet;

import project.tasks_management.dao.Dao;
import project.tasks_management.entities.Projet;
import project.tasks_management.entities.Responsable;
import project.tasks_management.entities.Task;

import java.util.List;

public interface ProjetDAO extends Dao<Projet> {
    public List<Projet> getProjetsByResponsable(Responsable r);
    public Projet getProjetByTask(Task t);
}
