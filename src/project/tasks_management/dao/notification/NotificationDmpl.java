package project.tasks_management.dao.notification;

import project.tasks_management.dao.SingletonConnexionDB;
import project.tasks_management.entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotificationDmpl implements NotificationDAO {
    @Override
    public List findAll() {
        List<Notification> notifications = new ArrayList<>();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select * from notification");
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                Notification n=new Notification();
                n.setID(rs.getLong("ID"));
                n.setTITLE(rs.getString("TITLE"));
                n.setDATE(rs.getDate("DATE"));
                n.setDESCRIPTION(rs.getString("DESCRIPTION"));
                notifications.add(n);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return notifications;
    }

    @Override
    public Notification findOne(long id) {
        Notification n=new Notification();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select * from notification where ID=?");
            pstm.setLong(1,id);
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                n.setID(rs.getLong("ID"));
                n.setTITLE(rs.getString("TITLE"));
                n.setDATE(rs.getDate("DATE"));
                n.setDESCRIPTION(rs.getString("DESCRIPTION"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public Notification save(Notification n) {
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("insert into notification (ID,TITLE,DATE,DESCRIPTION,TASK_ID,INTERVENANT_ID) values (?,?,?,?,?,?)");
            pstm.setLong(1,n.getID());
            pstm.setString(2,n.getTITLE());
            pstm.setString(3, n.getDESCRIPTION());
            pstm.setLong(4, n.getTASK().getID());
            pstm.setLong(5, n.getINTERVENENT().getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public boolean delete(Notification n) {
        Connection connection=new SingletonConnexionDB().getConnexion();
        try {
            PreparedStatement pstm=connection.prepareStatement("delete projet where ID=?");
            pstm.setLong(1,n.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Notification update(Notification n) {
        Connection connection=new SingletonConnexionDB().getConnexion();
        try {
            PreparedStatement pstm=connection.prepareStatement("update notification set TITLE=?,DATE=?,DESCRIPTION=?,TASK_ID=?,INTERVENANT=? where ID=?");
            pstm.setLong(1,n.getID());
            pstm.setString(2,n.getTITLE());
            pstm.setString(3, n.getDESCRIPTION());
            pstm.setLong(4, n.getTASK().getID());
            pstm.setLong(5, n.getINTERVENENT().getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public List<Notification> getNotificationByTask(Task t){
        List<Notification> notifications = new ArrayList<>();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select n.ID,n.TITLE,n.DATE,n.DESCRIPTION,n.TASK_ID,n.INTERVENANT_ID from notification n,task t where n.TASK_ID=t.ID and t.ID=?");
            pstm.setLong(1,t.getID());
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                Notification n=new Notification();
                n.setID(rs.getLong("ID"));
                n.setTITLE(rs.getString("TITLE"));
                n.setDATE(rs.getDate("DATE"));
                n.setDESCRIPTION(rs.getString("DESCRIPTION"));
                notifications.add(n);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return notifications;
    }

    @Override
    public List<Notification> getNotificationByIntervenant(Intervenant i) {
        List<Notification> notifications = new ArrayList<>();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select n.ID,n.TITLE,n.DATE,n.DESCRIPTION,n.TASK_ID,n.INTERVENANT_ID from notification n,user i where i.isIntervenant=true and i.ID=n.INTERVENANT_ID and n.INTERVENANT_ID=?");
            pstm.setLong(1,i.getID());
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                Notification n=new Notification();
                n.setID(rs.getLong("ID"));
                n.setTITLE(rs.getString("TITLE"));
                n.setDATE(rs.getDate("DATE"));
                n.setDESCRIPTION(rs.getString("DESCRIPTION"));
                notifications.add(n);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return notifications;
    }
}
