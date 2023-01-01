package project.tasks_management.services.responsable;

import project.tasks_management.dao.responsable.ResponsableDmpl;
import project.tasks_management.entities.Responsable;
import project.tasks_management.services.Service;

import java.util.List;

public class responsable implements Service<Responsable> {
    static ResponsableDmpl rdmpl;

    @Override
    public void add(Responsable responsable) {
        rdmpl.save(responsable);
    }

    @Override
    public void delete(Responsable responsable) {
        rdmpl.delete(responsable);
    }

    @Override
    public void update(Responsable responsable) {
        rdmpl.update(responsable);
    }

    @Override
    public List<Responsable> get() {
        return rdmpl.findAll();
    }
}
