package project.tasks_management.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Intervenent extends User implements Serializable {
    List<Task> TASKS=new ArrayList<>();

    public Intervenent(){
        super();
    }

    public Intervenent(long ID, String NOM, String PRENOM, String CIN, String TEL,Compte COMPTE,List<Task> TASKS) {
        super(ID, NOM, PRENOM, CIN, TEL,COMPTE, false, true);
        this.TASKS=TASKS;
    }

    public List<Task> getTASKS() {
        return TASKS;
    }

    public void setTASKS(List<Task> TASKS) {
        this.TASKS = TASKS;
    }
}
