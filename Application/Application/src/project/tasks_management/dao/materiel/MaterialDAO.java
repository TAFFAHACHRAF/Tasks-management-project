package project.tasks_management.dao.materiel;

import project.tasks_management.dao.Dao;
import project.tasks_management.entities.*;

import java.util.List;

public interface MaterialDAO extends Dao<Materiel> {
    public List<Materiel> getMaterielsByResponsable(Responsable r);
    public List<Materiel> getMaterielsByTask(Task t);
}
