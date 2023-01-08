package project.tasks_management.entities;

import java.io.Serializable;
public class OrderDeTravail implements Serializable {
    private long ID=0;
    private String DESCRIPTION="";
    private String TITLE="";
    private Task task;

    public OrderDeTravail(){ }

    public OrderDeTravail(long ID, String DESCRIPTION, String TITLE, Task task) {
        this.ID = ID;
        this.DESCRIPTION = DESCRIPTION;
        this.TITLE = TITLE;
        this.task = task;
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

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
