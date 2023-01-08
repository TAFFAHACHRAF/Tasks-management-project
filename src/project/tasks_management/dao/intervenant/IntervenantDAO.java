package project.tasks_management.dao.intervenant;


import project.tasks_management.dao.Dao;
import project.tasks_management.entities.Intervenant;
import project.tasks_management.entities.Responsable;
import project.tasks_management.entities.Task;

import java.util.List;

public interface IntervenantDAO extends Dao<Intervenant> {
    List<Intervenant> getIntervenantsByTask(Task t);
}
