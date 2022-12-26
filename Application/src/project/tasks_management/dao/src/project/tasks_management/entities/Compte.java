package project.tasks_management.entities;

import java.io.Serializable;

public class Compte implements Serializable {
    private long ID=0;
    private String EMAIL="";
    private String PASSWORD="";
    public Compte() {}

    public Compte(long ID, String EMAIL, String PASSWORD) {
        this.ID = ID;
        this.EMAIL = EMAIL;
        this.PASSWORD = PASSWORD;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
}
