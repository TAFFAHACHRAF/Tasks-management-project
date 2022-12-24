package taffah.ennani.tasks_management.dao.entities;

import java.io.Serializable;

public class Produit implements Serializable {
    private int ID;
    private String NOM;
    private String DESCRIPTION;
    private float prix;
    private int QUANTITE;

    public Produit() { }

    public Produit(int ID, String NOM, String DESCRIPTION, float prix, int QUANTITE) {
        this.ID = ID;
        this.NOM = NOM;
        this.DESCRIPTION = DESCRIPTION;
        this.prix = prix;
        this.QUANTITE = QUANTITE;
    }

    public int getID() {
        return ID;
    }

    public String getNOM() {
        return NOM;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public float getPrix() {
        return prix;
    }

    public int getQUANTITE() {
        return QUANTITE;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setQUANTITE(int QUANTITE) {
        this.QUANTITE = QUANTITE;
    }
}
