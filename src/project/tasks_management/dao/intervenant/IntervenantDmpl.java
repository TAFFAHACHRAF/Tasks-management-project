package project.tasks_management.dao.intervenant;

import project.tasks_management.dao.SingletonConnexionDB;
import project.tasks_management.dao.notification.NotificationDmpl;
import project.tasks_management.dao.task.TaskDmpl;
import project.tasks_management.entities.Intervenant;
import project.tasks_management.entities.Notification;
import project.tasks_management.entities.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IntervenantDmpl implements IntervenantDAO {
    @Override
    public List findAll() {
        List<Intervenant> Intervenants = new ArrayList<>();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select * from user where isIntervenant=1");
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                Intervenant i=new Intervenant();
                i.setID(rs.getInt("ID"));
                i.setNOM(rs.getString("NOM"));
                i.setPRENOM(rs.getString("PRENOM"));
                i.setTEL(rs.getString("TEL"));
                i.setEMAIL(rs.getString("EMAIL"));
                i.setPASSWORD(rs.getString("PASSWORD"));

                // affecter notifications
                /*NotificationDmpl n=new NotificationDmpl();
                if(n.getNotificationByIntervenant(i) != null) {
                    List<Notification> ns = n.getNotificationByIntervenant(i);
                    i.setNOTIFICATIONS(ns);
                }*/

                // affecter tasks
                /*TaskDmpl t=new TaskDmpl();
                if(t.getTasksByIntervenant(i) != null){
                    List<Task> ts=t.getTasksByIntervenant(i);
                    i.setTASK(ts);
                }*/

                Intervenants.add(i);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Intervenants;
    }

    @Override
    public Intervenant findOne(long id) {
        Intervenant i=new Intervenant();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select * from user where isIntervenant=1 and ID=?");
            pstm.setLong(1,id);
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){
                i.setID(rs.getLong("ID"));
                i.setNOM(rs.getString("NOM"));
                i.setPRENOM(rs.getString("PRENOM"));
                i.setTEL(rs.getString("TEL"));
                i.setEMAIL(rs.getString("EMAIL"));
                i.setPASSWORD(rs.getString("PASSWORD"));

                // affecter notifications
                /*NotificationDmpl n=new NotificationDmpl();
                if(n.getNotificationByIntervenant(i) != null) {
                    List<Notification> ns = n.getNotificationByIntervenant(i);
                    i.setNOTIFICATIONS(ns);
                }*/

                // affecter tasks
                /*TaskDmpl t=new TaskDmpl();
                if(t.getTasksByIntervenant(i) != null){
                    List<Task> ts=t.getTasksByIntervenant(i);
                    i.setTASK(ts);
                }*/
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return i;
    }

    public Intervenant findByEmailAndPassword(String email , String password) {
        Intervenant i=new Intervenant();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select * from user where isResponsable=1 and EMAIL=? AND PASSWORD=?");
            pstm.setString(1,email);
            pstm.setString(2,password);
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){
                i.setID(rs.getLong("ID"));
                i.setNOM(rs.getString("NOM"));
                i.setPRENOM(rs.getString("PRENOM"));
                i.setTEL(rs.getString("TEL"));
                i.setEMAIL(rs.getString("EMAIL"));
                i.setPASSWORD(rs.getString("PASSWORD"));

                // affecter notifications
                /*NotificationDmpl n=new NotificationDmpl();
                if(n.getNotificationByIntervenant(i) != null) {
                    List<Notification> ns = n.getNotificationByIntervenant(i);
                    i.setNOTIFICATIONS(ns);
                }*/

                // affecter tasks
                /*TaskDmpl t=new TaskDmpl();
                if(t.getTasksByIntervenant(i) != null){
                    List<Task> ts=t.getTasksByIntervenant(i);
                    i.setTASK(ts);
                }*/
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public Intervenant save(Intervenant i) {
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("insert into user (NOM,PRENOM,CIN,TEL,EMAIL,PASSWORD,isResponsable,isIntervenant) values (?,?,?,?,?,?,0,1)");
            pstm.setString(1,i.getNOM());
            pstm.setString(2,i.getPRENOM());
            pstm.setString(3,i.getCIN());
            pstm.setString(4,i.getTEL());
            pstm.setString(5,i.getEMAIL());
            pstm.setString(6,i.getPASSWORD());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public boolean delete(Intervenant i) {
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("delete from user where ID=? and isIntervenant=1");
            pstm.setLong(1,i.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Intervenant update(Intervenant i) {
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("update user set NOM=?,PRENOM=?,CIN=?,TEL=?,EMAIL=?,PASSWORD=? where ID=? and isIntervenant=1");
            pstm.setString(1,i.getNOM());
            pstm.setString(2,i.getPRENOM());
            pstm.setString(3,i.getCIN());
            pstm.setString(4,i.getTEL());
            pstm.setString(5,i.getEMAIL());
            pstm.setString(6,i.getPASSWORD());
            pstm.setLong(7,i.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public List<Intervenant> getIntervenantsByTask(Task t){
        List<Intervenant> Intervenants = new ArrayList<>();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select i.ID,i.NOM,i.PRENOM,i.CIN,i.TEL,i.EMAIL,i.PASSWORD from user i,affecter_intervenant aff,task t where isIntervenant=1 and i.ID=aff.ID_INTERVENANT and t.ID=aff.ID_TASK and t.ID=?");
            pstm.setLong(1,t.getID());
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                Intervenant i=new Intervenant();
                i.setID(rs.getInt("ID"));
                i.setNOM(rs.getString("NOM"));
                i.setPRENOM(rs.getString("PRENOM"));
                i.setTEL(rs.getString("TEL"));
                i.setEMAIL(rs.getString("EMAIL"));
                i.setPASSWORD(rs.getString("PASSWORD"));

                // affecter notifications
                /*NotificationDmpl n=new NotificationDmpl();
                if(n.getNotificationByIntervenant(i) != null) {
                    List<Notification> ns = n.getNotificationByIntervenant(i);
                    i.setNOTIFICATIONS(ns);
                }*/

                // affecter tasks
                /*TaskDmpl tt=new TaskDmpl();
                if(tt.getTasksByIntervenant(i) != null){
                    List<Task> ts=tt.getTasksByIntervenant(i);
                    i.setTASK(ts);
                }*/

                Intervenants.add(i);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Intervenants;
    }

}
