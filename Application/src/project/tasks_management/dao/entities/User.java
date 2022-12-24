package project.tasks_management.dao.entities;

import java.io.Serializable;

public class User implements Serializable {
    private long ID=0;
    private String NOM="";
    private String PRENOM="";
    private String CIN="";
    private String TEL="";
    private  Compte COMPTE=new Compte();
    private boolean isResponsable=false;
    private boolean isIntervenent=false;

    public User(){ }

    public User(long ID, String NOM, String PRENOM, String CIN, String TEL,Compte COMPTE, boolean isResponsable, boolean isIntervenent) {
        this.ID = ID;
        this.NOM = NOM;
        this.PRENOM = PRENOM;
        this.CIN = CIN;
        this.TEL = TEL;
        this.COMPTE=COMPTE;
        this.isResponsable = isResponsable;
        this.isIntervenent = isIntervenent;
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

    public boolean isResponsable() {
        return isResponsable;
    }

    public void setResponsable(boolean responsable) {
        isResponsable = responsable;
    }

    public boolean isIntervenent() {
        return isIntervenent;
    }

    public void setIntervenent(boolean intervenent) {
        isIntervenent = intervenent;
    }

    public Compte getCOMPTE() {
        return COMPTE;
    }

    public void setCOMPTE(Compte COMPTE) {
        this.COMPTE = COMPTE;
    }
}
