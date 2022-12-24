package project.tasks_management.dao.entities;

import java.io.Serializable;
import java.util.Date;

public class Notification implements Serializable {
    private long ID=0;
    private String TITLE="";
    private Date DATE=new Date();
    private String DESCRIPTION="";
    private Task TASK=new Task();
    private Intervenent INTERVENENT=new Intervenent();

    public Notification() {}

    public Notification(long ID, String TITLE, Date DATE, String DESCRIPTION,Task TASK,Intervenent INTERVENENT) {
        this.ID = ID;
        this.TITLE = TITLE;
        this.DATE = DATE;
        this.DESCRIPTION = DESCRIPTION;
        this.TASK=TASK;
        this.INTERVENENT=INTERVENENT;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public Date getDATE() {
        return DATE;
    }

    public void setDATE(Date DATE) {
        this.DATE = DATE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }
}
