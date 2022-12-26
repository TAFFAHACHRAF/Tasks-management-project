package project.tasks_management.dao;

import project.tasks_management.dao.compte.CompteDmpl;
import project.tasks_management.entities.Compte;
import project.tasks_management.entities.Intervenent;
import project.tasks_management.dao.intervenent.IntervenentDmpl;

import java.sql.SQLException;

public class Test {
    public static void main(String args[]) throws SQLException {
       IntervenentDmpl inter=new IntervenentDmpl();
       System.out.println(inter.findOne(9).getCOMPTE().getPASSWORD());
    }
}
