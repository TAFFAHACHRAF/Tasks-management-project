package project.tasks_management.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Responsable extends User implements Serializable {
    private boolean isResponsable=true;
    private List<Projet> PROJETS=new ArrayList<>();
    private List<Materiel> MATERIELS=new ArrayList<>();

    public Responsable(){
        super();
    }

    public Responsable(long ID, String NOM, String PRENOM, String CIN, String TEL,String EMAIL,String PASSWORD) {
        super(ID, NOM, PRENOM, CIN, TEL,EMAIL,PASSWORD);
    }

    public boolean getIsResponsable() {
        return isResponsable;
    }

    public List<Projet> getPROJETS() {
        return PROJETS;
    }

    public void setPROJETS(List<Projet> PROJETS) {
        this.PROJETS = PROJETS;
    }

    public List<Materiel> getMATERIELS() {
        return MATERIELS;
    }

    public void setMATERIELS(List<Materiel> MATERIELS) {
        this.MATERIELS = MATERIELS;
    }
}
