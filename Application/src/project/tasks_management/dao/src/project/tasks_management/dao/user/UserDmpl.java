/*package project.tasks_management.dao.user;

import project.tasks_management.dao.SingletonConnexionDB;
import project.tasks_management.entities.Compte;
import project.tasks_management.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDmpl implements UserDAO {
    private Connection conn;

    public void UserDao(SingletonConnexionDB conn) {
        this.conn = conn.getConnexion();
    }

    public User save(User user) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO user (nom, prenom, cin, tel, isResponsable, isIntervenent , COMPTE_ID) VALUES (?, ?, ?,?, ?, ?, ?)");
        ps.setString(1, user.getNOM());
        ps.setString(2, user.getPRENOM());
        ps.setString(3, user.getCIN());
        ps.setString(4, user.getTEL());
        ps.setBoolean(5, user.getIsResponsable());
        ps.setBoolean(6, user.getIsIntervenent());
        ps.setLong(7, user.getCOMPTE().getID());
        ps.executeUpdate();
        ps.close();
        return user;
    }


    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM user");
        ResultSet resultSet = ps.executeQuery();
        while (ps.next()) {
            long ID = resultSet.getLong("ID");
            String NOM = resultSet.getString("NOM");
            String PRENOM = resultSet.getString("PRENOM");
            String CIN = resultSet.getString("CIN");
            String TEL = resultSet.getString("TEL");
            Compte COMPTE = resultSet.getObject("COMPTE", Compte.class);
            boolean isResponsable = resultSet.getBoolean("isResponsable");
            boolean isIntervenent = resultSet.getBoolean("isIntervenent");
            User user = new User(ID, NOM, PRENOM, CIN, TEL, COMPTE, isResponsable, isIntervenent);
            users.add(user);
        }

        return users;
    }

    public User findOne(int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM user WHERE id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new User(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("cin"),
                    rs.getString("tel"),
                    rs.getBoolean("isResponsable"),
                    rs.getBoolean("isIntervenent"),
                    rs.getLong("COMPTE_ID")
            );
        }
        return null;
    }

    public User update(User user) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE user SET nom = ?, prenom = ?, cin = ?, tel = ? , isResponsable = ? , isIntervenent = ? WHERE id = ?");
        ps.setString(1, user.getNOM());
        ps.setString(2, user.getPRENOM());
        ps.setString(3, user.getCIN());
        ps.setString(4, user.getTEL());
        ps.setBoolean(5, user.getIsIntervenent());
        ps.setBoolean(6, user.getIsResponsable());
        ps.setLong(7, user.getID());
        ps.executeUpdate();
        ps.close();
        return user;
    }

    public boolean delete(User user) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(
                "DELETE FROM user WHERE id = ?");
        ps.setLong(1, user.getID());
        ps.executeUpdate();
        ps.close();
        return true;
    }

}*/
