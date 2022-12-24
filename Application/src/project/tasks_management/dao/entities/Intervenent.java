package project.tasks_management.dao.entities;

import java.util.ArrayList;
import java.util.List;

public class Intervenent extends User {
    List<Task> TASKS=new ArrayList<>();

    public Intervenent(){
        super();
    }

    public Intervenent(long ID, String NOM, String PRENOM, String CIN, String TEL,Compte COMPTE,List<Task> TASKS) {
        super(ID, NOM, PRENOM, CIN, TEL,COMPTE, false, true);
        this.TASKS=TASKS;
    }
}
