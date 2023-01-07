package project.tasks_management.presentation;

import project.tasks_management.entities.Intervenant;
import project.tasks_management.entities.Materiel;
import project.tasks_management.entities.Responsable;
import project.tasks_management.entities.Task;
import project.tasks_management.services.intervenant.intervenant;
import project.tasks_management.services.materiel.materiel;
import project.tasks_management.services.notification.notification;
import project.tasks_management.services.order_de_travail.order_de_travail;
import project.tasks_management.services.projet.projet;
import project.tasks_management.services.responsable.responsable;
import project.tasks_management.services.task.task;

import java.sql.SQLException;

public class Application
{
    public static void main(String[] args) throws SQLException {
        // les test des services du programme
        intervenant inter1=new intervenant();
        System.out.println(inter1.retournerIntervenants().size());
        Intervenant i1=new Intervenant();
        inter1.supprimerIntervenant(i1);

        responsable resp1=new responsable();
        System.out.println(resp1.retournerResponsables().size());

        task t1=new task();
        System.out.println(t1.retournerTasks().size());

        projet pr1=new projet();
        System.out.println(pr1.retournerProjets().size());

        order_de_travail ord1=new order_de_travail();
        System.out.println(ord1.retournerOrderDeTravails().size());

        notification not1=new notification();
        System.out.println(not1.retournerNotifications().size());

        materiel mat1=new materiel();
        System.out.println(mat1.retournerMateriels().size());

        Intervenant i=new Intervenant(0,"iueizfh","oijef","oifje","efoij","oifehj","fiuh");
        inter1.ajouterIntervenant(i);
        inter1.ajouterIntervenant(i);

        /*Materiel m=new Materiel(110,"rofj","rifj");
        m.setRESPONSABLE(resp1.retournerResponsables().get(0));
        mat1.ajouterMateriel(m);*/

        /*t1.affecter_intervenant(t1.retournerTasks().get(0),inter1.retournerIntervenants().get(1));
        t1.affecter_materiel(t1.retournerTasks().get(0),mat1.retournerMateriels().get(1));*/

        t1.affecter_materiel(t1.retournerTasks().get(0),mat1.retournerMateriels().get(0));
        t1.affecter_intervenant(t1.retournerTasks().get(0),inter1.retournerIntervenants().get(0));
        t1.supprimer_affectation_intervenant(t1.retournerTasks().get(0),inter1.retournerIntervenants().get(0));
    }
}