package project.tasks_management.dao.abdelmalek;

import project.tasks_management.dao.SingletonConnexionDB;
import project.tasks_management.dao.entities.Materiel;
import project.tasks_management.dao.entities.Task;
import project.tasks_management.dao.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class materialDmpl implements MaterialDAO{

    private Connection conn;

    public void AccountDao(SingletonConnexionDB conn) {
        this.conn = conn.getConnexion();
    }

    @Override
    public List<Materiel> findAll() throws SQLException {
        String sql = "SELECT * FROM materiel";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Materiel> materiels = new ArrayList<>();
        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            String type = resultSet.getString("type");
            String nom = resultSet.getString("nom");
            int userId = resultSet.getInt("id");
            UserDAO userDAO = new UserDAO(connection);
            User user = userDAO.findOne(userId);
            List<Task> tasks = resultSet.getObject("tasks", List.class);
            long responsableId = resultSet.getLong("responsable_id");
            ResponsableDAO responsableDAO = new ResponsableDAO(connection);
            Responsable responsable = responsableDAO.findOne(responsableId);
            Materiel materiel = new Materiel(id, type, nom, user, tasks, responsable);
            materiels.add(materiel);
        }
        return materiels;
    }

    @Override
    public Materiel findOne(int id) throws SQLException {
        String sql = "SELECT * FROM materiel WHERE id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            long materielId = resultSet.getLong("id");
            String type = resultSet.getString("type");
            String nom = resultSet.getString("nom");
            long userId = resultSet.getLong("user_id");
            UserDAO userDAO = new UserDAO(connection);
            User user = userDAO.findOne(userId);
            List<Task> tasks = resultSet.getObject("tasks", List.class);
            long responsableId = resultSet.getLong("responsable_id");
            ResponsableDAO responsableDAO = new ResponsableDAO(connection);
            Responsable responsable = responsableDAO.getResponsableById(responsableId);
            return new Materiel(materielId, type, nom, user, tasks, responsable);
        }
        return null;
    }

    @Override
    public Materiel save(Materiel m) throws SQLException {
        String sql = "INSERT INTO materiel (id, type, nom, user_id, tasks, responsable_id) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setLong(1, m.getID());
        statement.setString(2, m.getTYPE());
        statement.setString(3, m.getNOM());
        statement.setLong(4, m.getUSER().getID());
        statement.setObject(5, m.getTASKS());
        statement.setLong(6, m.getRESPONSABLE().getID());
        statement.executeUpdate();
        return o;
    }

    @Override
    public boolean delete(Materiel m) throws SQLException {
        String sql = "DELETE FROM materiel WHERE id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setLong(1, m.getID());
        statement.executeUpdate();
        return true;
    }

    @Override
    public Materiel update(Materiel m) throws SQLException {
        String sql = "UPDATE materiel SET type = ?, nom = ?, user_id = ?, tasks = ?, responsable_id = ? WHERE id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, m.getTYPE());
        statement.setString(2, m.getNOM());
        statement.setLong(3, m.getUSER().getID());
        statement.setObject(4, m.getTASKS());
        statement.setLong(5, m.getRESPONSABLE().getID());
        statement.setLong(6, m.getID());
        statement.executeUpdate();

        return m;
    }
}
