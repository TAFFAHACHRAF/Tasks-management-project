package project.tasks_management.entities;

import java.io.Serializable;

public class OrderDeTravail implements Serializable {
    private long ID=0;
    private String DESCRIPTION="";
    private String TITLE="";
    private Task TASK=new Task();

    public OrderDeTravail() {}

    public OrderDeTravail(long ID, String DESCRIPTION, String TITLE,Task TASK) {
        this.ID = ID;
        this.DESCRIPTION = DESCRIPTION;
        this.TITLE = TITLE;
        this.TASK=TASK;
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

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public Task getTASK() {
        return TASK;
    }

    public void setTASK(Task TASK) {
        this.TASK = TASK;
    }
}
