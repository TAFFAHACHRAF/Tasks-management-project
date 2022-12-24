package project.tasks_management.dao.entities;

public class OrderDeTravail {
    private long ID=0;
    private String DESCRIPTION="";
    private String TITLE="";

    public OrderDeTravail() {}

    public OrderDeTravail(long ID, String DESCRIPTION, String TITLE) {
        this.ID = ID;
        this.DESCRIPTION = DESCRIPTION;
        this.TITLE = TITLE;
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
}
