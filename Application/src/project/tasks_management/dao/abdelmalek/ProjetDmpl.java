package project.tasks_management.dao.abdelmalek;

import project.tasks_management.dao.Dao;
import project.tasks_management.dao.SingletonConnexionDB;
import project.tasks_management.dao.entities.Projet;

import java.sql.*;
import java.util.List;

public class ProjetDmpl implements ProjetDAO {
    private Connection conn;

    public void AccountDao(SingletonConnexionDB conn) {
        this.conn = conn.getConnexion();
    }

    @Override
    public Projet findOne(int id) throws SQLException {
        Projet projet = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM projets WHERE id = ?");
            stmt.setLong(1, ID);
            rs = stmt.executeQuery();
            if (rs.next()) {
                projet = new Projet(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getDate("date"),
                        rs.getList("diagrammes"),
                        rs.getList("tasks"),
                        rs.getObject("responsable", Responsable.class)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return projet;
    }

    @Override
    public List<Projet> findAll() throws SQLException {
        List<Projet> projets = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM projets");
            while (rs.next()) {
                projets.add(new Projet(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getDate("date"),
                        rs.getList("diagrammes"),
                        rs.getList("tasks"),
                        rs.getObject("responsable", Responsable.class)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return projets;
    }

    @Override
    public Projet save(Projet p) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO projets (id, title, date, diagrammes, tasks, responsable) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setLong(1, p.getID());
            stmt.setString(2, p.getTITLE());
            stmt.setDate(3, p.getDate());
            stmt.setList(4, p.getDIAGRAMMES());
            stmt.setList(5, p.getTASKS());
            stmt.setObject(6, p.getRESPONSABLE());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return p;
    }

    @Override
    public boolean delete(Projet p) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("DELETE FROM projets WHERE id = ?");
            stmt.setLong(1, p.getID());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public Projet update(Projet p) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("UPDATE projets SET title = ?, date = ?, diagrammes = ?, tasks = ?, responsable = ? WHERE id = ?");
            stmt.setString(1, p.getTITLE());
            stmt.setDate(2, p.getDate());
            stmt.setList(3, p.getDIAGRAMMES());
            stmt.setList(4, p.getTASKS());
            stmt.setObject(5, p.getRESPONSABLE());
            stmt.setLong(6, p.getID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return o;
    }
}
