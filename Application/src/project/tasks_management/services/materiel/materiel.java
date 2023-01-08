package project.tasks_management.services.materiel;

import project.tasks_management.dao.materiel.MaterialDmpl;
import project.tasks_management.entities.Materiel;
import project.tasks_management.entities.Responsable;
import project.tasks_management.entities.Task;

import java.sql.SQLException;
import java.util.List;

public class materiel implements materielService{
    MaterialDmpl mdmpl=new MaterialDmpl();

    @Override
    public List<Materiel> retournerMateriels() throws SQLException {
        return mdmpl.findAll();
    }

    @Override
    public Materiel retournerMaterielParId(Materiel m) throws SQLException {
        return mdmpl.findOne(m.getID());
    }

    @Override
    public List<Materiel> retournerMaterielsParTask(Task t) throws SQLException {
        return mdmpl.getMaterielsByTask(t);
    }

    @Override
    public List<Materiel> retournerMaterielsParResponsable(Responsable r) throws SQLException {
        return mdmpl.getMaterielsByResponsable(r);
    }

    @Override
    public void ajouterMateriel(Materiel m) throws SQLException {
        mdmpl.save(m);
    }

    @Override
    public void supprimerMateriel(Materiel m) throws SQLException {
        mdmpl.delete(m);
    }

    @Override
    public void modifierMateriel(Materiel m) throws SQLException {
        mdmpl.update(m);
    }

    @Override
    public void enregistrerMateriel(Materiel m) throws SQLException {
        mdmpl.save(m);
    }
}
