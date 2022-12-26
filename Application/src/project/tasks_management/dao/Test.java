package project.tasks_management.dao;

import project.tasks_management.dao.compte.CompteDmpl;
import project.tasks_management.dao.projet.ProjetDmpl;
import project.tasks_management.dao.responsable.ResponsableDmpl;
import project.tasks_management.entities.Compte;
import project.tasks_management.entities.Intervenent;
import project.tasks_management.dao.intervenent.IntervenentDmpl;
import project.tasks_management.entities.Responsable;

import java.sql.SQLException;

public class Test {
    public static void main(String args[]) throws SQLException {
       /*IntervenentDmpl inter=new IntervenentDmpl();
       System.out.println(inter.findOne(9).getCOMPTE().getPASSWORD());*/
        /*ResponsableDmpl rsmpl=new ResponsableDmpl();
        Responsable r=new Responsable();
        r.setID(9);
        System.out.println(rsmpl.getProjetsByReponsable(r).get(0).getDIAGRAMMES().get(0).getTYPE());*/
        ProjetDmpl pdml=new ProjetDmpl();
        System.out.println(pdml.findAll().get(0).getTITLE());
    }
}
