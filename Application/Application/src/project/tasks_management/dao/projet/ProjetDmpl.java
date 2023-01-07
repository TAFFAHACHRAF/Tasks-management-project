package project.tasks_management.dao.projet;

import project.tasks_management.dao.SingletonConnexionDB;
import project.tasks_management.dao.responsable.ResponsableDmpl;
import project.tasks_management.dao.task.TaskDmpl;
import project.tasks_management.entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetDmpl implements ProjetDAO {
    @Override
    public List findAll() {
        List<Projet> Projets = new ArrayList<>();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select * from projet");
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                Projet p=new Projet();
                p.setID(rs.getLong("ID"));
                p.setTITLE(rs.getString("TITLE"));
                p.setDate(rs.getDate("DATE_DEBUT"));

                // affecter responsable
                /*ResponsableDmpl r=new ResponsableDmpl();
                if(r.getResponsablesByProjet(p)!=null) {
                    Responsable rr = r.getResponsablesByProjet(p);
                    p.setRESPONSABLE(rr);
                }*/

                // affecter tasks
                /*TaskDmpl t=new TaskDmpl();
                if(t.getTasksByProjet(p)!=null) {
                    List<Task> ts = t.getTasksByProjet(p);
                    p.setTASKS(ts);
                }*/

                Projets.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Projets;
    }

    @Override
    public Projet findOne(long id) {
        Projet p=new Projet();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select * from projet where ID=?");
            pstm.setLong(1,id);
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){
                p.setID(rs.getInt("ID"));
                p.setTITLE(rs.getString("TITLE"));
                p.setDate(rs.getDate("DATE_DEBUT"));

                // affecter responsable
                /*ResponsableDmpl r=new ResponsableDmpl();
                if(r.getResponsablesByProjet(p)!=null) {
                    Responsable rr = r.getResponsablesByProjet(p);
                    p.setRESPONSABLE(rr);
                }*/

                // affecter tasks
                /*TaskDmpl t=new TaskDmpl();
                if(t.getTasksByProjet(p)!=null) {
                    List<Task> ts = t.getTasksByProjet(p);
                    p.setTASKS(ts);
                }*/
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public Projet save(Projet p) {
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("insert into projet (ID,TITLE,DATE_DEBUT,RESPONSABLE_ID) values (?,?,?,?)");
            pstm.setLong(1,p.getID());
            pstm.setString(2,p.getTITLE());
            pstm.setDate(3, (Date) p.getDate());
            pstm.setLong(4, p.getRESPONSABLE().getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public boolean delete(Projet p) {
        Connection connection=new SingletonConnexionDB().getConnexion();
        try {
            PreparedStatement pstm=connection.prepareStatement("delete projet where ID=?");
            pstm.setLong(1,p.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Projet update(Projet p) {
        Connection connection=new SingletonConnexionDB().getConnexion();
        try {
            PreparedStatement pstm=connection.prepareStatement("update projet set TITLE=?,DATE_DEBUT=?,RESPONSABLE_ID=? where ID=?");
            pstm.setString(1,p.getTITLE());
            pstm.setDate(2, (Date) p.getDate());
            pstm.setLong(3, p.getRESPONSABLE().getID());
            pstm.setLong(4,p.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public List<Projet> getProjetsByResponsable(Responsable r) {
        List<Projet> Projets = new ArrayList<>();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select p.TITLE,p.DATE_DEBUT,p.RESPONSABLE_ID from projet p,responsable r where p.ID_RESPONSABLE=r.ID and r.ID=?");
            pstm.setLong(1,r.getID());
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                Projet p=new Projet();
                p.setID(rs.getLong("ID"));
                p.setTITLE(rs.getString("TITLE"));
                p.setDate(rs.getDate("DATE_DEBUT"));

                // affecter responsable
                /*ResponsableDmpl rr=new ResponsableDmpl();
                if(rr.getResponsablesByProjet(p)!=null) {
                    Responsable rrr = rr.getResponsablesByProjet(p);
                    p.setRESPONSABLE(rrr);
                }*/

                // affecter tasks
                /*TaskDmpl t=new TaskDmpl();
                if(t.getTasksByProjet(p)!=null) {
                    List<Task> ts = t.getTasksByProjet(p);
                    p.setTASKS(ts);
                }*/

                Projets.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Projets;
    }

    @Override
    public Projet getProjetByTask(Task t) {
        Projet p=new Projet();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select p.ID,p.TITLE,p.DATE_DEBUT,p.RESPONSABLE_ID from projet p,task t where p.ID=t.PROJET_ID and t.ID=?");
            pstm.setLong(1,t.getID());
            ResultSet rs=pstm.executeQuery();
            if (rs.next()){
                p.setID(rs.getLong("ID"));
                p.setTITLE(rs.getString("TITLE"));
                p.setDate(rs.getDate("DATE_DEBUT"));

                // affecter responsable
                /*ResponsableDmpl r=new ResponsableDmpl();
                if(r.getResponsablesByProjet(p)!=null) {
                    Responsable rr = r.getResponsablesByProjet(p);
                    p.setRESPONSABLE(rr);
                }*/

                // affecter tasks
                /*TaskDmpl tt=new TaskDmpl();
                if(tt.getTasksByProjet(p)!=null) {
                    List<Task> ts = tt.getTasksByProjet(p);
                    p.setTASKS(ts);
                }*/
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return p;
    }
}
