package project.tasks_management.dao.task;

import project.tasks_management.dao.SingletonConnexionDB;
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
                tasks.add(task);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return tasks;
    }


    @Override
    public Task findOne(int id) throws SQLException {
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
            PreparedStatement pstm=connection.prepareStatement("insert into task (DESCRIPTION,DATE_DEBUT,DATE_FIN,TITLE,PROJET_ID,INTERVENANT_ID,MATERIEL_ID) values (?,?,?,?,?,?,?)");
            pstm.setString(1,t.getDESCRIPTION());
            pstm.setDate(2, (Date) t.getDATE_DEBUT());
            pstm.setDate(3, (Date) t.getDATE_FIN());
            pstm.setLong(5,t.getPROJET().getID());
            pstm.setLong(6,t.getINTERVENT().getID());
            pstm.setLong(7,t.getMATERIEL().getID());
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
            PreparedStatement pstm=connection.prepareStatement("update task set DESCRIPTION=?,DATE_DEBUT=?,DATE_FIN=?,TITLE=?,PROJET_ID=?,INTERVENANT_ID=?,MATERIEL_ID=?) where ID=?");
            pstm.setString(1,t.getDESCRIPTION());
            pstm.setDate(2, (Date) t.getDATE_DEBUT());
            pstm.setDate(3, (Date) t.getDATE_FIN());
            pstm.setString(4, t.getTITLE());
            pstm.setLong(5,t.getPROJET().getID());
            pstm.setLong(6,t.getINTERVENT().getID());
            pstm.setLong(7,t.getMATERIEL().getID());
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
            PreparedStatement statement = connection.prepareStatement("SELECT t.DESCRIPTION,t.DATE_DEBUT,t.DATE_FIN,t.TITLE,t.PROJET_ID,t.INTERVENANT_ID,t.MATERIEL_ID FROM task t,user u where t.ID=u.TASK_ID and u.TASK_ID=?");
            statement.setLong(1,i.getTASK().getID());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Task task = new Task();
                task.setID(resultSet.getLong("ID"));
                task.setDESCRIPTION(resultSet.getString("DESCRIPTION"));
                task.setDATE_DEBUT(resultSet.getDate("DATE_DEBUT"));
                task.setDATE_FIN(resultSet.getDate("DATE_FIN"));
                task.setTITLE(resultSet.getString("TITLE"));
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
            PreparedStatement statement = connection.prepareStatement("SELECT t.DESCRIPTION,t.DATE_DEBUT,t.DATE_FIN,t.TITLE,t.PROJET_ID,t.INTERVENANT_ID,t.MATERIEL_ID FROM task t where t.PROJET_ID=?");
            statement.setLong(1,p.getID());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Task task = new Task();
                task.setID(resultSet.getLong("ID"));
                task.setDESCRIPTION(resultSet.getString("DESCRIPTION"));
                task.setDATE_DEBUT(resultSet.getDate("DATE_DEBUT"));
                task.setDATE_FIN(resultSet.getDate("DATE_FIN"));
                task.setTITLE(resultSet.getString("TITLE"));
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
            PreparedStatement statement = connection.prepareStatement("SELECT t.DESCRIPTION,t.DATE_DEBUT,t.DATE_FIN,t.TITLE,t.PROJET_ID,t.INTERVENANT_ID,t.MATERIEL_ID FROM materiel m where m.TASK_ID=?");
            statement.setLong(1,m.getID());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Task task = new Task();
                task.setID(resultSet.getLong("ID"));
                task.setDESCRIPTION(resultSet.getString("DESCRIPTION"));
                task.setDATE_DEBUT(resultSet.getDate("DATE_DEBUT"));
                task.setDATE_FIN(resultSet.getDate("DATE_FIN"));
                task.setTITLE(resultSet.getString("TITLE"));
                tasks.add(task);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return tasks;
    }
}
