package project.tasks_management.services.materiel;

import project.tasks_management.dao.materiel.MaterialDmpl;
import project.tasks_management.entities.Materiel;
import project.tasks_management.services.Service;

import java.sql.SQLException;
import java.util.List;

public class materiel implements Service<Materiel> {
    static MaterialDmpl mdmpl;

    @Override
    public void add(Materiel materiel) throws SQLException {
        mdmpl.save(materiel);
    }

    @Override
    public void delete(Materiel materiel) throws SQLException {
        mdmpl.delete(materiel);
    }

    @Override
    public void update(Materiel materiel) throws SQLException {
        mdmpl.update(materiel);
    }

    @Override
    public List<Materiel> get() throws SQLException {
        return mdmpl.findAll();
    }
}
