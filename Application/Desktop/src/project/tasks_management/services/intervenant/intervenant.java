package project.tasks_management.services.intervenant;

import project.tasks_management.dao.intervenant.IntervenantDmpl;
import project.tasks_management.entities.Intervenant;
import project.tasks_management.entities.Task;
import project.tasks_management.services.Service;

import java.sql.SQLException;
import java.util.List;

public class intervenant implements intervenantService{
    IntervenantDmpl idmpl=new IntervenantDmpl();


    @Override
    public List<Intervenant> retournerIntervenants() throws SQLException {
        return idmpl.findAll();
    }

    @Override
    public Intervenant retournerIntervenantParId(Intervenant i) throws SQLException {
        return idmpl.findOne(i.getID());
    }

    @Override
    public List<Intervenant> retournerIntervenantsParTask(Task t) throws SQLException {
        return idmpl.getIntervenantsByTask(t);
    }

    @Override
    public void ajouterIntervenant(Intervenant i) throws SQLException {
        idmpl.save(i);
    }

    @Override
    public void supprimerIntervenant(Intervenant i) throws SQLException {
        idmpl.delete(i);
    }

    @Override
    public void modifierIntervenant(Intervenant i) throws SQLException {
        idmpl.update(i);
    }

    @Override
    public void enregistrerIntervenant(Intervenant i) throws SQLException {
        idmpl.save(i);
    }

    @Override
    public Intervenant findByEmailAndPassword(String email, String password) {
        return idmpl.findByEmailAndPassword(email , password);
    }
}
