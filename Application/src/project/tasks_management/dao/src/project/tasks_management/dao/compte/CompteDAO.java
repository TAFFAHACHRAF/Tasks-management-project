package project.tasks_management.dao.compte;

import project.tasks_management.dao.Dao;
import project.tasks_management.entities.Compte;

public interface CompteDAO extends Dao<Compte> {
    Compte getCompteByEmailAndPassword(String email,String password);
}
