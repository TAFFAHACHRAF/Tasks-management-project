package project.tasks_management.services.intervenant;

import project.tasks_management.dao.intervenant.IntervenantDmpl;
import project.tasks_management.entities.Intervenant;
import project.tasks_management.services.Service;

import java.util.List;

public class intervenant implements Service<Intervenant> {
    static IntervenantDmpl idmpl;

    @Override
    public void add(Intervenant intervenant) {
        idmpl.save(intervenant);
    }

    @Override
    public void delete(Intervenant intervenant) {
        idmpl.delete(intervenant);
    }

    @Override
    public void update(Intervenant intervenant) {
        idmpl.update(intervenant);
    }

    @Override
    public List<Intervenant> get() {
        return idmpl.findAll();
    }
}
