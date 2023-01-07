package project.tasks_management.dao.task;

import project.tasks_management.dao.SingletonConnexionDB;
import project.tasks_management.dao.intervenant.IntervenantDAO;
import project.tasks_management.dao.intervenant.IntervenantDmpl;
import project.tasks_management.dao.materiel.MaterialDmpl;
import project.tasks_management.dao.notification.NotificationDmpl;
import project.tasks_management.dao.order_de_travail.OrderDeTravailDmpl;
import project.tasks_management.dao.projet.ProjetDmpl;
import project.tasks_management.entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDmpl implements TaskDAO {

    @Override
    public List<Task> findAll() throws SQLException {
        List<Task> tasks=new ArrayList<>();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM task ");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Task task = new Task();
                task.setID(resultSet.getLong("ID"));
                task.setDESCRIPTION(resultSet.getString("DESCRIPTION"));
                task.setDATE_DEBUT(resultSet.getDate("DATE_DEBUT"));
                task.setDATE_FIN(resultSet.getDate("DATE_FIN"));
                task.setTITLE(resultSet.getString("TITLE"));

                // affecter projet
                /*ProjetDmpl p=new ProjetDmpl();
                if(p.getProjetByTask(task)!=null) {
                    Projet pp = p.getProjetByTask(task);
                    task.setPROJET(pp);
                }*/

                // affecter materiels
                /*MaterialDmpl m=new MaterialDmpl();
                if(m.getMaterielsByTask(task)!=null) {
                    List<Materiel> ms = m.getMaterielsByTask(task);
                    task.setMATERIEL(ms);
                }*/

                // affecter intervenants
                /*IntervenantDAO i=new IntervenantDmpl();
                if(i.getIntervenantsByTask(task)!=null) {
                    List<Intervenant> is = i.getIntervenantsByTask(task);
                    task.setINTERVENT(is);
                }*/

                // affecter notifications
                /*NotificationDmpl n=new NotificationDmpl();
                if(n.getNotificationByTask(task)!=null) {
                    List<Notification> ns = n.getNotificationByTask(task);
                    task.setNOTIFICATIONS(ns);
                }*/

                // affecter orders_de_travail
                /*OrderDeTravailDmpl o=new OrderDeTravailDmpl();
                if(o.getOrderDeTravailByTask(task)!=null) {
                    List<OrderDeTravail> os = o.getOrderDeTravailByTask(task);
                    task.setORDERS_DE_TRAVAIL(os);
                }*/

                tasks.add(task);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return tasks;
    }


    @Override
    public Task findOne(long id) throws SQLException {
        Task task = new Task();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM task");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                task.setID(resultSet.getLong("ID"));
                task.setDESCRIPTION(resultSet.getString("DESCRIPTION"));
                task.setDATE_DEBUT(resultSet.getDate("DATE_DEBUT"));
                task.setDATE_FIN(resultSet.getDate("DATE_FIN"));
                task.setTITLE(resultSet.getString("TITLE"));

                // affecter projet
                /*ProjetDmpl p=new ProjetDmpl();
                if(p.getProjetByTask(task)!=null) {
                    Projet pp = p.getProjetByTask(task);
                    task.setPROJET(pp);
                }*/

                // affecter materiels
                /*MaterialDmpl m=new MaterialDmpl();
                if(m.getMaterielsByTask(task)!=null) {
                    List<Materiel> ms = m.getMaterielsByTask(task);
                    task.setMATERIEL(ms);
                }*/

                // affecter intervenants
                /*IntervenantDAO i=new IntervenantDmpl();
                if(i.getIntervenantsByTask(task)!=null) {
                    List<Intervenant> is = i.getIntervenantsByTask(task);
                    task.setINTERVENT(is);
                }*/

                // affecter notifications
                /*NotificationDmpl n=new NotificationDmpl();
                if(n.getNotificationByTask(task)!=null) {
                    List<Notification> ns = n.getNotificationByTask(task);
                    task.setNOTIFICATIONS(ns);
                }*/

                // affecter orders_de_travail
                /*OrderDeTravailDmpl o=new OrderDeTravailDmpl();
                if(o.getOrderDeTravailByTask(task)!=null) {
                    List<OrderDeTravail> os = o.getOrderDeTravailByTask(task);
                    task.setORDERS_DE_TRAVAIL(os);
                }*/
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return task;
    }

    @Override
    public Task save(Task t) throws SQLException {
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("insert into task (DESCRIPTION,DATE_DEBUT,DATE_FIN,TITLE,PROJET_ID) values (?,?,?,?,?)");
            pstm.setString(1,t.getDESCRIPTION());
            pstm.setDate(2, (Date) t.getDATE_DEBUT());
            pstm.setDate(3, (Date) t.getDATE_FIN());
            pstm.setLong(5,t.getPROJET().getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public boolean delete(Task t) throws SQLException {
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("delete task where ID=?");
            pstm.setLong(1,t.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Task update(Task t) throws SQLException {
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("update task set DESCRIPTION=?,DATE_DEBUT=?,DATE_FIN=?,TITLE=?,PROJET_ID=?) where ID=?");
            pstm.setString(1,t.getDESCRIPTION());
            pstm.setDate(2, (Date) t.getDATE_DEBUT());
            pstm.setDate(3, (Date) t.getDATE_FIN());
            pstm.setString(4, t.getTITLE());
            pstm.setLong(5,t.getPROJET().getID());
            pstm.setLong(8,t.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public Task getTaskByOrderDeTravail(OrderDeTravail o){
        Task task=new Task();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("SELECT t.DESCRIPTION,t.DATE_DEBUT,t.DATE_FIN,t.TITLE,t.PROJET_ID,t.INTERVENANT_ID,t.MATERIEL_ID FROM task t,order_de_travail o where t.ID=o.TASK_ID and o.TASK_ID=?");
            pstm.setLong(1,o.getTask().getID());
            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                task.setID(resultSet.getLong("ID"));
                task.setDESCRIPTION(resultSet.getString("DESCRIPTION"));
                task.setDATE_DEBUT(resultSet.getDate("DATE_DEBUT"));
                task.setDATE_FIN(resultSet.getDate("DATE_FIN"));
                task.setTITLE(resultSet.getString("TITLE"));

                // affecter projet
                /*ProjetDmpl p=new ProjetDmpl();
                if(p.getProjetByTask(task)!=null) {
                    Projet pp = p.getProjetByTask(task);
                    task.setPROJET(pp);
                }*/

                // affecter materiels
                /*MaterialDmpl m=new MaterialDmpl();
                if(m.getMaterielsByTask(task)!=null) {
                    List<Materiel> ms = m.getMaterielsByTask(task);
                    task.setMATERIEL(ms);
                }*/

                // affecter intervenants
                /*IntervenantDAO i=new IntervenantDmpl();
                if(i.getIntervenantsByTask(task)!=null) {
                    List<Intervenant> is = i.getIntervenantsByTask(task);
                    task.setINTERVENT(is);
                }*/

                // affecter notifications
                /*NotificationDmpl n=new NotificationDmpl();
                if(n.getNotificationByTask(task)!=null) {
                    List<Notification> ns = n.getNotificationByTask(task);
                    task.setNOTIFICATIONS(ns);
                }*/

                // affecter orders_de_travail
                /*OrderDeTravailDmpl ord=new OrderDeTravailDmpl();
                if(ord.getOrderDeTravailByTask(task)!=null) {
                    List<OrderDeTravail> os = ord.getOrderDeTravailByTask(task);
                    task.setORDERS_DE_TRAVAIL(os);
                }*/
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return task;
    }
    @Override
    public List<Task> getTasksByNotification(Notification n){
        List<Task> tasks=new ArrayList<>();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement statement = connection.prepareStatement("SELECT t.DESCRIPTION,t.DATE_DEBUT,t.DATE_FIN,t.TITLE,t.PROJET_ID,t.INTERVENANT_ID,t.MATERIEL_ID FROM task t,notification n where t.ID=n.TASK_ID and n.TASK_ID=?");
            statement.setLong(1,n.getTASK().getID());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Task task = new Task();
                task.setID(resultSet.getLong("ID"));
                task.setDESCRIPTION(resultSet.getString("DESCRIPTION"));
                task.setDATE_DEBUT(resultSet.getDate("DATE_DEBUT"));
                task.setDATE_FIN(resultSet.getDate("DATE_FIN"));
                task.setTITLE(resultSet.getString("TITLE"));

                // affecter projet
                /*ProjetDmpl p=new ProjetDmpl();
                if(p.getProjetByTask(task)!=null) {
                    Projet pp = p.getProjetByTask(task);
                    task.setPROJET(pp);
                }*/

                // affecter materiels
                /*MaterialDmpl m=new MaterialDmpl();
                if(m.getMaterielsByTask(task)!=null) {
                    List<Materiel> ms = m.getMaterielsByTask(task);
                    task.setMATERIEL(ms);
                }*/

                // affecter intervenants
                /*IntervenantDAO i=new IntervenantDmpl();
                if(i.getIntervenantsByTask(task)!=null) {
                    List<Intervenant> is = i.getIntervenantsByTask(task);
                    task.setINTERVENT(is);
                }*/

                // affecter notifications
                /*NotificationDmpl not=new NotificationDmpl();
                if(not.getNotificationByTask(task)!=null) {
                    List<Notification> ns = not.getNotificationByTask(task);
                    task.setNOTIFICATIONS(ns);
                }*/

                // affecter orders_de_travail
                /*OrderDeTravailDmpl o=new OrderDeTravailDmpl();
                if(o.getOrderDeTravailByTask(task)!=null) {
                    List<OrderDeTravail> os = o.getOrderDeTravailByTask(task);
                    task.setORDERS_DE_TRAVAIL(os);
                }*/

                tasks.add(task);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return tasks;
    }
    @Override
    public List<Task> getTasksByIntervenant(Intervenant i){
        List<Task> tasks=new ArrayList<>();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement statement = connection.prepareStatement("SELECT t.ID,t.DESCRIPTION,t.DATE_DEBUT,t.DATE_FIN,t.TITLE,t.PROJET_ID FROM task t,user u ,affecter_intervenant aff where t.ID=aff.ID_TASK and u.ID=aff.ID_INTERVENANT and u.ID=?");
            statement.setLong(1,i.getID());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Task task = new Task();
                task.setID(resultSet.getLong("ID"));
                task.setDESCRIPTION(resultSet.getString("DESCRIPTION"));
                task.setDATE_DEBUT(resultSet.getDate("DATE_DEBUT"));
                task.setDATE_FIN(resultSet.getDate("DATE_FIN"));
                task.setTITLE(resultSet.getString("TITLE"));

                // affecter projet
                /*ProjetDmpl p=new ProjetDmpl();
                if(p.getProjetByTask(task)!=null) {
                    Projet pp = p.getProjetByTask(task);
                    task.setPROJET(pp);
                }*/

                // affecter materiels
                /*MaterialDmpl m=new MaterialDmpl();
                if(m.getMaterielsByTask(task)!=null) {
                    List<Materiel> ms = m.getMaterielsByTask(task);
                    task.setMATERIEL(ms);
                }*/

                // affecter intervenants
                /*IntervenantDAO in=new IntervenantDmpl();
                if(in.getIntervenantsByTask(task)!=null) {
                    List<Intervenant> is = in.getIntervenantsByTask(task);
                    task.setINTERVENT(is);
                }*/

                // affecter notifications
                /*NotificationDmpl n=new NotificationDmpl();
                if(n.getNotificationByTask(task)!=null) {
                    List<Notification> ns = n.getNotificationByTask(task);
                    task.setNOTIFICATIONS(ns);
                }*/

                // affecter orders_de_travail
                /*OrderDeTravailDmpl o=new OrderDeTravailDmpl();
                if(o.getOrderDeTravailByTask(task)!=null) {
                    List<OrderDeTravail> os = o.getOrderDeTravailByTask(task);
                    task.setORDERS_DE_TRAVAIL(os);
                }*/

                tasks.add(task);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return tasks;
    }
    @Override
    public List<Task> getTasksByProjet(Projet p){
        List<Task> tasks=new ArrayList<>();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement statement = connection.prepareStatement("SELECT t.ID,t.DESCRIPTION,t.DATE_DEBUT,t.DATE_FIN,t.TITLE FROM task t where t.PROJET_ID=?");
            statement.setLong(1,p.getID());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Task task = new Task();
                task.setID(resultSet.getLong("ID"));
                task.setDESCRIPTION(resultSet.getString("DESCRIPTION"));
                task.setDATE_DEBUT(resultSet.getDate("DATE_DEBUT"));
                task.setDATE_FIN(resultSet.getDate("DATE_FIN"));
                task.setTITLE(resultSet.getString("TITLE"));

                // affecter projet
                /* ProjetDmpl pr=new ProjetDmpl();
                if(pr.getProjetByTask(task)!=null) {
                    Projet pp = pr.getProjetByTask(task);
                    task.setPROJET(pp);
                } */

                // affecter materiels
                /*MaterialDmpl m=new MaterialDmpl();
                if(m.getMaterielsByTask(task)!=null) {
                    List<Materiel> ms = m.getMaterielsByTask(task);
                    task.setMATERIEL(ms);
                }*/

                // affecter intervenants
                /*IntervenantDAO i=new IntervenantDmpl();
                if(i.getIntervenantsByTask(task)!=null) {
                    List<Intervenant> is = i.getIntervenantsByTask(task);
                    task.setINTERVENT(is);
                }*/

                // affecter notifications
                /*NotificationDmpl n=new NotificationDmpl();
                if(n.getNotificationByTask(task)!=null) {
                    List<Notification> ns = n.getNotificationByTask(task);
                    task.setNOTIFICATIONS(ns);
                }*/

                // affecter orders_de_travail
                /*OrderDeTravailDmpl o=new OrderDeTravailDmpl();
                if(o.getOrderDeTravailByTask(task)!=null) {
                    List<OrderDeTravail> os = o.getOrderDeTravailByTask(task);
                    task.setORDERS_DE_TRAVAIL(os);
                }*/

                tasks.add(task);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return tasks;
    }
    @Override
    public List<Task> getTasksByMateriel(Materiel m){
        List<Task> tasks=new ArrayList<>();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement statement = connection.prepareStatement("SELECT t.ID,t.DESCRIPTION,t.DATE_DEBUT,t.DATE_FIN,t.TITLE FROM materiel m,task t,affecter_materiel aff where aff.ID_MATERIEL=m.ID and aff.ID_TASK=t.ID and m.ID=?");
            statement.setLong(1,m.getID());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Task task = new Task();
                task.setID(resultSet.getLong("ID"));
                task.setDESCRIPTION(resultSet.getString("DESCRIPTION"));
                task.setDATE_DEBUT(resultSet.getDate("DATE_DEBUT"));
                task.setDATE_FIN(resultSet.getDate("DATE_FIN"));
                task.setTITLE(resultSet.getString("TITLE"));

                // affecter projet
                /*ProjetDmpl p=new ProjetDmpl();
                if(p.getProjetByTask(task)!=null) {
                    Projet pp = p.getProjetByTask(task);
                    task.setPROJET(pp);
                }*/

                // affecter materiels
                /*MaterialDmpl mm=new MaterialDmpl();
                if(mm.getMaterielsByTask(task)!=null) {
                    List<Materiel> ms = mm.getMaterielsByTask(task);
                    task.setMATERIEL(ms);
                }*/

                // affecter intervenants
                /*IntervenantDAO i=new IntervenantDmpl();
                if(i.getIntervenantsByTask(task)!=null) {
                    List<Intervenant> is = i.getIntervenantsByTask(task);
                    task.setINTERVENT(is);
                }*/

                // affecter notifications
                /*NotificationDmpl n=new NotificationDmpl();
                if(n.getNotificationByTask(task)!=null) {
                    List<Notification> ns = n.getNotificationByTask(task);
                    task.setNOTIFICATIONS(ns);
                }*/

                // affecter orders_de_travail
                /*OrderDeTravailDmpl o=new OrderDeTravailDmpl();
                if(o.getOrderDeTravailByTask(task)!=null) {
                    List<OrderDeTravail> os = o.getOrderDeTravailByTask(task);
                    task.setORDERS_DE_TRAVAIL(os);
                }*/

                tasks.add(task);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return tasks;
    }

    @Override
    public Materiel affecter_materiel(Task t,Materiel m){
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("insert into affecter_materiel values (0,?,?)");
            pstm.setLong(1,t.getID());
            pstm.setLong(2,m.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return m;
    }

    @Override
    public Intervenant affecter_intervenant(Task t,Intervenant i){
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("insert into affecter_intervenant values (0,?,?)");
            pstm.setLong(1,t.getID());
            pstm.setLong(2,i.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public boolean delete_affectation_materiel(Task t,Materiel m){
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("delete from affecter_materiel where ID_TASK=? and ID_MATERIEL=?");
            pstm.setLong(1,t.getID());
            pstm.setLong(2,m.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean delete_affectation_intervenant(Task t,Intervenant i){
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("delete from affecter_intervenant where ID_TASK=? and ID_INTERVENANT=?");
            pstm.setLong(1,t.getID());
            pstm.setLong(2,i.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
}
