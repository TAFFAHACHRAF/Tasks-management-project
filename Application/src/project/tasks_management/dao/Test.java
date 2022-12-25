package project.tasks_management.dao;

import project.tasks_management.dao.entities.Compte;
import project.tasks_management.dao.entities.Intervenent;
import project.tasks_management.dao.entities.User;

public class Test {
    public static void main(String args[]){
        IntervenentImpl inter=new IntervenentImpl();
        Intervenent i=new Intervenent();
        i.setNOM("iuzehfuehfiuzef");
        i.getCOMPTE().setPASSWORD("pozefozjefpojzefioj");
        inter.save(i);
    }
}
