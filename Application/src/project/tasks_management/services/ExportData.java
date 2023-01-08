package project.tasks_management.services;

import project.tasks_management.services.intervenant.intervenant;
import project.tasks_management.services.materiel.materiel;
import project.tasks_management.services.notification.notification;
import project.tasks_management.services.order_de_travail.order_de_travail;
import project.tasks_management.services.projet.projet;
import project.tasks_management.services.responsable.responsable;
import project.tasks_management.services.task.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class ExportData {
    public void exportData(String fileName) throws FileNotFoundException, SQLException {
        File csvFile=new File("index.csv");
        PrintWriter out = new PrintWriter(csvFile);

        materiel mat=new materiel();
        out.println("'ID','TYPE','NOM','RESPONSABLE_ID'");
        for(int i=0;i<mat.retournerMateriels().size();i++){
            out.println("'"+mat.retournerMateriels().get(i).getID()+"','"+mat.retournerMateriels().get(i).getTYPE()+"','"+mat.retournerMateriels().get(i).getNOM()+"','"+mat.retournerMateriels().get(i).getRESPONSABLE().getID()+"'");
        }

        notification not=new notification();
        out.println("'ID','TITLE','DATE','DESCRIPTION','TASK_ID','INTERVENANT_ID'");
        for(int i=0;i<not.retournerNotifications().size();i++){
            out.println("'"+not.retournerNotifications().get(i).getID()+"','"+not.retournerNotifications().get(i).getTITLE()+"','"+not.retournerNotifications().get(i).getDATE()+"','"+not.retournerNotifications().get(i).getDESCRIPTION()+"'"+"','"+not.retournerNotifications().get(i).getTASK().getID()+"'"+"','"+not.retournerNotifications().get(i).getINTERVENENT().getID()+"'");
        }

        order_de_travail ord=new order_de_travail();
        out.println("'ID','TITLE','DESCRIPTION','TASK_ID'");
        for(int i=0;i<ord.retournerOrderDeTravails().size();i++){
            out.println("'"+ord.retournerOrderDeTravails().get(i).getID()+"','"+not.retournerNotifications().get(i).getTITLE()+"','"+not.retournerNotifications().get(i).getDESCRIPTION()+"'"+"','"+not.retournerNotifications().get(i).getTASK().getID()+"'");
        }

        projet pro=new projet();
        out.println("'ID','TITLE','DATE_DEBUT','RESPONSABLE_ID'");
        for(int i=0;i<pro.retournerProjets().size();i++){
            out.println("'"+pro.retournerProjets().get(i).getID()+"','"+pro.retournerProjets().get(i).getTITLE()+"','"+pro.retournerProjets().get(i).getDate()+"'"+"','"+pro.retournerProjets().get(i).getRESPONSABLE().getID()+"'");
        }

        task tas=new task();
        out.println("'ID','DESCRIPTION','DATE_DEBUT','DATE_FIN','TITLE','PROJET_ID");
        for(int i=0;i<tas.retournerTasks().size();i++){
            out.println("'"+tas.retournerTasks().get(i).getID()+"','"+tas.retournerTasks().get(i).getDESCRIPTION()+"','"+tas.retournerTasks().get(i).getDATE_DEBUT()+"'"+"','"+tas.retournerTasks().get(i).getDATE_FIN()+"'"+"','"+tas.retournerTasks().get(i).getTITLE()+"'"+"','"+tas.retournerTasks().get(i).getPROJET().getID()+"'");
        }

        out.println("'ID','NOM','PRENOM','TEL','CIN','EMAIL','PASSWORD','isResponsable','isIntervenant'");
        responsable resp=new responsable();
        for(int i=0;i<resp.retournerResponsables().size();i++){
            out.println("'"+resp.retournerResponsables().get(i).getID()+"','"+resp.retournerResponsables().get(i).getNOM()+"','"+resp.retournerResponsables().get(i).getPRENOM()+"','"+resp.retournerResponsables().get(i).getTEL()+"','"+resp.retournerResponsables().get(i).getCIN()+"','"+resp.retournerResponsables().get(i).getEMAIL()+"','"+resp.retournerResponsables().get(i).getPASSWORD()+"'1,','0'");
        }

        intervenant inter=new intervenant();
        for(int i=0;i<inter.retournerIntervenants().size();i++){
            out.println("'"+inter.retournerIntervenants().get(i).getID()+"','"+inter.retournerIntervenants().get(i).getNOM()+"','"+inter.retournerIntervenants().get(i).getPRENOM()+"','"+inter.retournerIntervenants().get(i).getTEL()+"','"+inter.retournerIntervenants().get(i).getCIN()+"','"+inter.retournerIntervenants().get(i).getEMAIL()+"','"+inter.retournerIntervenants().get(i).getPASSWORD()+"'"+"','"+inter.retournerIntervenants().get(i).getPASSWORD()+"'0','1'");
        }

        out.close();
    }
}
