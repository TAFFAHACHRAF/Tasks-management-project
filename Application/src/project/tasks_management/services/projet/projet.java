package project.tasks_management.services.projet;

import project.tasks_management.dao.projet.ProjetDmpl;
import project.tasks_management.entities.Projet;
import project.tasks_management.services.Service;

import java.util.List;

public class projet implements Service<Projet> {
    static ProjetDmpl pdmpl;

    @Override
    public void add(Projet projet) {
        pdmpl.save(projet);
    }

    @Override
    public void delete(Projet projet) {
        pdmpl.delete(projet);
    }

    @Override
    public void update(Projet projet) {
        pdmpl.update(projet);
    }

    @Override
    public List<Projet> get() {
        return pdmpl.findAll();
    }
}
