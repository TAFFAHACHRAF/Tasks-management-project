package project.tasks_management.dao.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Responsable extends User implements Serializable {
    List<Projet> PROJETS=new ArrayList<>();
    List<Materiel> MATERIELS=new ArrayList<>();

    public Responsable(){
        super();
    }

    public Responsable(long ID, String NOM, String PRENOM, String CIN, String TEL,Compte COMPTE,List<Projet> PROJETS,List<Materiel> MATERIELS) {
        super(ID, NOM, PRENOM, CIN, TEL,COMPTE, true, false);
        this.PROJETS=PROJETS;
        this.MATERIELS=MATERIELS;
    }

}
