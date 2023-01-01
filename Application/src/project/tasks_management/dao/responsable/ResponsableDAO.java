package project.tasks_management.dao.responsable;

import project.tasks_management.dao.Dao;
import project.tasks_management.entities.Materiel;
import project.tasks_management.entities.Projet;
import project.tasks_management.entities.Responsable;

import java.util.List;

public interface ResponsableDAO extends Dao<Responsable> {
    List<Responsable> getResponsablesByMateriel(Materiel m);
    List<Responsable> getResponsablesByProjet(Projet p);
}
