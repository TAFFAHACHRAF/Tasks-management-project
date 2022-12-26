package project.tasks_management.dao.task;

import project.tasks_management.dao.SingletonConnexionDB;
import project.tasks_management.entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDmpl implements TaskDAO {

    private Connection conn;

    public void TaskDmpl(SingletonConnexionDB conn) {
        this.conn = conn.getConnexion();
    }

    @Override
    public List<Task> findAll() throws SQLException {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            long ID = resultSet.getLong("ID");
            String DESCRIPTION = resultSet.getString("DESCRIPTION");
            Date DATE_DEBUT = resultSet.getDate("DATE_DEBUT");
            Date DATE_FIN = resultSet.getDate("DATE_FIN");
            String TITLE = resultSet.getString("TITLE");
            List<Materiel> MATERIELS = resultSet.getObject("MATERIELS", List.class);
            List<OrderDeTravail> ORDERS_DE_TRAVAIL = resultSet.getObject("ORDERS_DE_TRAVAIL", List.class);
            List<Notification> NOTIFICATIONS = resultSet.getObject("NOTIFICATIONS", List.class);
            List<User> INTERVENTS = resultSet.getObject("INTERVENTS", List.class);
            Projet PROJET = resultSet.getObject("PROJET", Projet.class);
            Task task = new Task(ID, DESCRIPTION, DATE_DEBUT, DATE_FIN, TITLE, MATERIELS, ORDERS_DE_TRAVAIL, NOTIFICATIONS, INTERVENTS, PROJET);
            tasks.add(task);
        }
        return tasks;
    }


    @Override
    public Task findOne(int id) throws SQLException {
        String sql = "SELECT * FROM tasks WHERE ID = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        Task task = null;
        if (resultSet.next()) {
            long ID = resultSet.getLong("ID");
            String DESCRIPTION = resultSet.getString("DESCRIPTION");
            Date DATE_DEBUT = resultSet.getDate("DATE_DEBUT");
            Date DATE_FIN = resultSet.getDate("DATE_FIN");
            String TITLE = resultSet.getString("TITLE");
            List<Materiel> MATERIELS = resultSet.getObject("MATERIELS", List.class);
            List<OrderDeTravail> ORDERS_DE_TRAVAIL = resultSet.getObject("ORDERS_DE_TRAVAIL", List.class);
            List<Notification> NOTIFICATIONS = resultSet.getObject("NOTIFICATIONS", List.class);
            List<User> INTERVENTS = resultSet.getObject("INTERVENTS", List.class);
            Projet PROJET = resultSet.getObject("PROJET", Projet.class);
            task = new Task(ID, DESCRIPTION, DATE_DEBUT, DATE_FIN, TITLE, MATERIELS, ORDERS_DE_TRAVAIL, NOTIFICATIONS, INTERVENTS, PROJET);
            return task;
        }

        return  task;
    }

    @Override
    public Task save(Task t) throws SQLException {
        String sql = "INSERT INTO tasks (ID, DESCRIPTION, DATE_DEBUT, DATE_FIN, TITLE, MATERIELS, ORDERS_DE_TRAVAIL, NOTIFICATIONS, INTERVENTS, PROJET) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setLong(1, t.getID());
        statement.setString(2, t.getDESCRIPTION());
        statement.setDate(3, (Date) t.getDATE_DEBUT());
        statement.setDate(4, (Date) t.getDATE_FIN());
        statement.setString(5, t.getTITLE());
        statement.setObject(6, t.getMATERIELS());
        statement.setObject(7, t.getORDERS_DE_TRAVAIL());
        statement.setObject(8, t.getNOTIFICATIONS());
        statement.setObject(9, t.getINTERVENTS());
        statement.setObject(10, t.getPROJET());
        statement.executeUpdate();

        return t;
    }

    @Override
    public boolean delete(Task t) throws SQLException {
        String sql = "DELETE FROM tasks WHERE ID = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setLong(1, t.getID());
        statement.executeUpdate();
        return true;
    }

    @Override
    public Task update(Task t) throws SQLException {
        String sql = "UPDATE tasks SET DESCRIPTION = ?, DATE_DEBUT = ?, DATE_FIN = ?, TITLE = ?, MATERIELS = ?, ORDERS_DE_TRAVAIL = ?, NOTIFICATIONS = ?, INTERVENTS = ?, PROJET = ? WHERE ID = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, t.getDESCRIPTION());
        statement.setDate(2, (Date) t.getDATE_DEBUT());
        statement.setDate(3, (Date) t.getDATE_FIN());
        statement.setString(4, t.getTITLE());
        statement.setObject(5, t.getMATERIELS());
        statement.setObject(6, t.getORDERS_DE_TRAVAIL());
        statement.setObject(7, t.getNOTIFICATIONS());
        statement.setObject(8, t.getINTERVENTS());
        statement.setObject(9, t.getPROJET());
        statement.setLong(10, t.getID());
        statement.executeUpdate();

        return t;
    }

    public List<Task> getTasksByResponsable(int responsable_id) {
        /*String sql = "SELECT * FROM tasks WHERE RESPONSABLE_ID = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setLong(1, responsable_id);
        ResultSet resultSet = statement.executeQuery();
        Task task = null;
        if (resultSet.next()) {
            long ID = resultSet.getLong("ID");
            String DESCRIPTION = resultSet.getString("DESCRIPTION");
            Date DATE_DEBUT = resultSet.getDate("DATE_DEBUT");
            Date DATE_FIN = resultSet.getDate("DATE_FIN");
            String TITLE = resultSet.getString("TITLE");
            List<Materiel> MATERIELS = resultSet.getObject("MATERIELS", List.class);
            List<OrderDeTravail> ORDERS_DE_TRAVAIL = resultSet.getObject("ORDERS_DE_TRAVAIL", List.class);
            List<Notification> NOTIFICATIONS = resultSet.getObject("NOTIFICATIONS", List.class);
            List<User> INTERVENTS = resultSet.getObject("INTERVENTS", List.class);
            Projet PROJET = resultSet.getObject("PROJET", Projet.class);
            task = new Task(ID, DESCRIPTION, DATE_DEBUT, DATE_FIN, TITLE, MATERIELS, ORDERS_DE_TRAVAIL, NOTIFICATIONS, INTERVENTS, PROJET);
            return task;
        }

        return  task;*/
        return null;
    }
}
