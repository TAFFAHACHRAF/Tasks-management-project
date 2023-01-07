package project.tasks_management.services.responsable;

import project.tasks_management.entities.Materiel;
import project.tasks_management.entities.Projet;
import project.tasks_management.entities.Responsable;
import project.tasks_management.services.Service;

import java.sql.SQLException;
import java.util.List;

public interface responsableService extends Service<Projet> {
    public List<Responsable> retournerResponsables() throws SQLException;
    public Responsable retournerResponsableParId(Responsable r) throws SQLException;
    public Responsable retournerResponsableParMateriel(Materiel m) throws SQLException;
    public Responsable retournerResponsableParProjet(Projet p) throws SQLException;
    public void ajouterResponsable(Responsable r) throws SQLException;

    public void supprimerResponsable(Responsable r) throws SQLException;

    public void modifierResponsable(Responsable r) throws SQLException;
    public void enregistrerResponsable(Responsable r) throws SQLException;
}
