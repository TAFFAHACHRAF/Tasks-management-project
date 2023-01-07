package project.tasks_management.entities;

import java.io.Serializable;
import java.util.Date;

public class Notification implements Serializable {
    private long ID=0;
    private String TITLE="";
    private Date DATE=new Date();
    private String DESCRIPTION="";
    private notificationType type;
    private Task TASK=new Task();
    private Intervenant INTERVENENT=new Intervenant();

    public Notification() {}

    public Notification(long ID, String TITLE, Date DATE, String DESCRIPTION,Task TASK,Intervenant INTERVENENT) {
        this.ID = ID;
        this.TITLE = TITLE;
        this.DATE = DATE;
        this.DESCRIPTION = DESCRIPTION;
        this.TASK=TASK;
        this.INTERVENENT=INTERVENENT;
    }

    public enum notificationType{
        Email,
        SMS
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

    public notificationType getType() {
        return type;
    }

    public void setType(notificationType type) {
        this.type = type;
    }

    public Task getTASK() {
        return TASK;
    }

    public void setTASK(Task TASK) {
        this.TASK = TASK;
    }

    public Intervenant getINTERVENENT() {
        return INTERVENENT;
    }

    public void setINTERVENENT(Intervenant INTERVENENT) {
        this.INTERVENENT = INTERVENENT;
    }
}
