package project.tasks_management.services.projet;

import project.tasks_management.entities.Projet;
import project.tasks_management.entities.Responsable;
import project.tasks_management.entities.Task;
import project.tasks_management.services.Service;

import java.sql.SQLException;
import java.util.List;

public interface projetService extends Service<Projet> {
    public List<Projet> retournerProjets() throws SQLException;
    public Projet retournerProjetParId(Projet p) throws SQLException;
    public List<Projet> retournerProjetsParResponsable(Responsable r) throws SQLException;
    public Projet retournerProjetParTask(Task t) throws SQLException;
    public void ajouterProjet(Projet p) throws SQLException;

    public void supprimerProjet(Projet p) throws SQLException;

    public void modifierProjet(Projet p) throws SQLException;
    public void enregistrerProjet(Projet p) throws SQLException;
}
