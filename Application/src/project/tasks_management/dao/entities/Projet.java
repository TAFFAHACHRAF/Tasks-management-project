package project.tasks_management.dao.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Projet {
    private long ID=0;
    private String TITLE="";
    private Date date=new Date();
    private List<Diagramme> DIAGRAMMES=new ArrayList<>();
    private List<Task> TASKS=new ArrayList<>();

    public Projet() {}

    public Projet(long ID, String TITLE, Date date, User user,List<Diagramme> DIAGRAMMES,List<Task> TASKS) {
        this.ID = ID;
        this.TITLE = TITLE;
        this.date = date;
        this.DIAGRAMMES=DIAGRAMMES;
        this.TASKS=TASKS;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Diagramme> getDIAGRAMMES() {
        return DIAGRAMMES;
    }

    public void setDIAGRAMMES(List<Diagramme> DIAGRAMMES) {
        this.DIAGRAMMES = DIAGRAMMES;
    }

    public List<Task> getTASKS() {
        return TASKS;
    }

    public void setTASKS(List<Task> TASKS) {
        this.TASKS = TASKS;
    }
}
