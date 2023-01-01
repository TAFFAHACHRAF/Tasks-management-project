package project.tasks_management.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Intervenant extends User implements Serializable {
    private Boolean isIntervenant=true;
    private Task TASK;
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

    public Task getTASK() {
        return TASK;
    }

    public void setTASK(Task TASK) {
        this.TASK = TASK;
    }

    public List<Notification> getNOTIFICATIONS() {
        return NOTIFICATIONS;
    }

    public void setNOTIFICATIONS(List<Notification> NOTIFICATIONS) {
        this.NOTIFICATIONS = NOTIFICATIONS;
    }
}
