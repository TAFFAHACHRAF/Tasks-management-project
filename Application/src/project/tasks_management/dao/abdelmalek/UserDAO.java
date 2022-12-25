package project.tasks_management.dao.abdelmalek;

import project.tasks_management.dao.Dao;
import project.tasks_management.dao.entities.Compte;
import project.tasks_management.dao.entities.User;

public interface UserDAO extends Dao<User> {
         Compte getComte(int id);
         void setCompte(String email, String password);
}
