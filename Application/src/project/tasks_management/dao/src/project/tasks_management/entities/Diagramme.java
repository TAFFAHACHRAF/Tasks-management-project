package project.tasks_management.entities;

import java.io.Serializable;

public class Diagramme implements Serializable {
    private long ID=0;
    private String TYPE="";
    private Projet PROJET=new Projet();

    public Diagramme() {}

    public Diagramme(long ID, String TYPE, Projet PROJET) {
        this.ID = ID;
        this.TYPE = TYPE;
        this.PROJET = PROJET;
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

    public Projet getPROJET() {
        return PROJET;
    }

    public void setPROJET(Projet PROJET) {
        this.PROJET = PROJET;
    }
}
