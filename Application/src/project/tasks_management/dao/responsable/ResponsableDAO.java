package project.tasks_management.dao.responsable;

import project.tasks_management.dao.Dao;
import project.tasks_management.entities.Projet;
import project.tasks_management.entities.Responsable;

import java.util.List;

public interface ResponsableDAO extends Dao<Responsable> {
    List<Projet> getProjetsByReponsable(Responsable r);
}
