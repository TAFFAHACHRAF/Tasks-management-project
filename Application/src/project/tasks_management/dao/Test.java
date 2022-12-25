package project.tasks_management.dao;

import project.tasks_management.entities.Intervenent;
import project.tasks_management.dao.intervenent.IntervenentDmpl;

public class Test {
    public static void main(String args[]){
        IntervenentDmpl inter=new IntervenentDmpl();
        Intervenent i=new Intervenent();
        i.setNOM("iuzehfuehfiuzef");
        i.getCOMPTE().setPASSWORD("pozefozjefpojzefioj");
        inter.save(i);
    }
}
