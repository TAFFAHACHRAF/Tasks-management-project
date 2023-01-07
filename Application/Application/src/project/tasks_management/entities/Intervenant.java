package project.tasks_management.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Intervenant extends User implements Serializable {
    private Boolean isIntervenant=true;
    private List<Task> TASK=new ArrayList<>();
    private List<Notification> NOTIFICATIONS=new ArrayList<>();
    public Intervenant(){
        super();
    }

    public Intervenant(long ID, String NOM, String PRENOM, String CIN, String TEL,String EMAIL,String PASSWORD) {
        super(ID, NOM, PRENOM, CIN, TEL,EMAIL,PASSWORD);
    }

    public Boolean getIntervenant() {
        return isIntervenant;
    }

    public void setIntervenant(Boolean intervenant) {
        isIntervenant = intervenant;
    }

    public List<Task> getTASK() {
        return TASK;
    }

    public void setTASK(List<Task> TASK) {
        this.TASK = TASK;
    }

    public List<Notification> getNOTIFICATIONS() {
        return NOTIFICATIONS;
    }

    public void setNOTIFICATIONS(List<Notification> NOTIFICATIONS) {
        this.NOTIFICATIONS = NOTIFICATIONS;
    }

    @Override
    public String toString() {
        return super.toString()+"Intervenant{" +
                "isIntervenant=" + isIntervenant +
                ", TASK=" + TASK +
                ", NOTIFICATIONS=" + NOTIFICATIONS +
                '}';
    }
}
