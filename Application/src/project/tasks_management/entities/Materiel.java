package project.tasks_management.entities;

import javafx.concurrent.Task;

import java.io.Serializable;

public class Materiel implements Serializable {
    private long ID=0;
    private String TYPE="";
    private String NOM="";
    private Task TASK;
    private Responsable RESPONSABLE=new Responsable();

    public Materiel() {}

    public Materiel(long ID, String TYPE, String NOM) {
        this.ID = ID;
        this.TYPE = TYPE;
        this.NOM = NOM;
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

    public Task getTASK() {
        return this.TASK;
    }

    public void setTASK(Task TASK) {
        this.TASK = TASK;
    }

    public Responsable getRESPONSABLE() {
        return RESPONSABLE;
    }

    public void setRESPONSABLE(Responsable RESPONSABLE) {
        this.RESPONSABLE = RESPONSABLE;
    }
}
