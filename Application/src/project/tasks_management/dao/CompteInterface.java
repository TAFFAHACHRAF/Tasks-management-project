package project.tasks_management.dao;

import project.tasks_management.dao.entities.Compte;

public interface CompteInterface extends Dao<Compte>{
    Compte getCompteByEmailAndPassword(String email,String password);

    Compte save(Compte c);

    boolean delete(Compte c);

    Compte update(Compte c);
}
