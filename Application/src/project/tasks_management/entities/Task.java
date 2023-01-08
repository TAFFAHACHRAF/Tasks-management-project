package project.tasks_management.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task implements Serializable {
    private long ID=0;
    private String DESCRIPTION="";
    private Date DATE_DEBUT=new Date();
    private Date DATE_FIN=new Date();
    private String TITLE="";
    private List<Materiel> MATERIELS=new ArrayList<>();
    private List<OrderDeTravail> ORDERS_DE_TRAVAIL=new ArrayList<>();
    private List<Notification> NOTIFICATIONS=new ArrayList<>();
    private List<Intervenant> INTERVENT=new ArrayList<>();
    private Projet PROJET=new Projet();

    public Task () {}

    public Task(long ID, String DESCRIPTION, Date DATE_DEBUT, Date DATE_FIN, String TITLE) {
        this.ID = ID;
        this.DESCRIPTION = DESCRIPTION;
        this.DATE_DEBUT = DATE_DEBUT;
        this.DATE_FIN = DATE_FIN;
        this.TITLE = TITLE;
        PROJET.setID(3);
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public Date getDATE_DEBUT() {
        return DATE_DEBUT;
    }

    public void setDATE_DEBUT(Date DATE_DEBUT) {
        this.DATE_DEBUT = DATE_DEBUT;
    }

    public Date getDATE_FIN() {
        return DATE_FIN;
    }

    public void setDATE_FIN(Date DATE_FIN) {
        this.DATE_FIN = DATE_FIN;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public List<Materiel> getMATERIEL() {
        return MATERIELS;
    }

    public void setMATERIEL(List<Materiel> MATERIEL) {
        this.MATERIELS = MATERIEL;
    }

    public List<OrderDeTravail> getORDERS_DE_TRAVAIL() {
        return ORDERS_DE_TRAVAIL;
    }

    public void setORDERS_DE_TRAVAIL(List<OrderDeTravail> ORDERS_DE_TRAVAIL) {
        this.ORDERS_DE_TRAVAIL = ORDERS_DE_TRAVAIL;
    }

    public List<Notification> getNOTIFICATIONS() {
        return NOTIFICATIONS;
    }

    public void setNOTIFICATIONS(List<Notification> NOTIFICATIONS) {
        this.NOTIFICATIONS = NOTIFICATIONS;
    }

    public List<Intervenant> getINTERVENT() {
        return INTERVENT;
    }

    public void setINTERVENT(List<Intervenant> INTERVENT) {
        this.INTERVENT = INTERVENT;
    }

    public Projet getPROJET() {
        return PROJET;
    }

    public void setPROJET(Projet PROJET) {
        this.PROJET = PROJET;
    }
}
