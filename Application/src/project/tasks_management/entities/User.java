package project.tasks_management.entities;

import java.io.Serializable;

public class User implements Serializable {
    private long ID=0;
    private String NOM="";
    private String PRENOM="";
    private String CIN="";
    private String TEL="";
    private String EMAIL="";
    private  String PASSWORD="";

    public User(){ }

    public User(long ID, String NOM, String PRENOM, String CIN, String TEL,String EMAIL,String PASSWORD) {
        this.ID = ID;
        this.NOM = NOM;
        this.PRENOM = PRENOM;
        this.CIN = CIN;
        this.TEL = TEL;
        this.EMAIL=EMAIL;
        this.PASSWORD=PASSWORD;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNOM() {
        return NOM;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    public String getPRENOM() {
        return PRENOM;
    }

    public void setPRENOM(String PRENOM) {
        this.PRENOM = PRENOM;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getTEL() {
        return TEL;
    }

    public void setTEL(String TEL) {
        this.TEL = TEL;
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

    @Override
    public String toString() {
        return "{" +
                "ID=" + ID +
                ", NOM='" + NOM + '\'' +
                ", PRENOM='" + PRENOM + '\'' +
                ", CIN='" + CIN + '\'' +
                ", TEL='" + TEL + '\'' +
                ", EMAIL='" + EMAIL + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                '}';
    }
}
