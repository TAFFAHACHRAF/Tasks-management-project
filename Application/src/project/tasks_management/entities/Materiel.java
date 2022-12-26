package project.tasks_management.entities;

import javafx.concurrent.Task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Materiel implements Serializable {
    private long ID=0;
    private String TYPE="";
    private String NOM="";
    private User USER=new User();
    private List<Task> TASKS=new ArrayList<>();
    private Responsable RESPONSABLE=new Responsable();


    public Materiel() {}

    public Materiel(long ID, String TYPE, String NOM, User USER,List<Task> TASKS,Responsable RESPONSABLE) {
        this.ID = ID;
        this.TYPE = TYPE;
        this.NOM = NOM;
        this.USER = USER;
        this.TASKS=TASKS;
        this.RESPONSABLE= RESPONSABLE;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getNOM() {
        return NOM;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    public User getUSER() {
        return USER;
    }

    public void setUSER(User USER) {
        this.USER = USER;
    }

    public List<Task> getTASKS() {
        return TASKS;
    }

    public void setTASKS(List<Task> TASKS) {
        this.TASKS = TASKS;
    }

    public Responsable getRESPONSABLE() {
        return RESPONSABLE;
    }

    public void setRESPONSABLE(Responsable RESPONSABLE) {
        this.RESPONSABLE = RESPONSABLE;
    }
}
