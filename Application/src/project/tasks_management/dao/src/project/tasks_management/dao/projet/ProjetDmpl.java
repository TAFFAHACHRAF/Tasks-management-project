package project.tasks_management.dao.projet;

import project.tasks_management.dao.SingletonConnexionDB;
import project.tasks_management.entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetDmpl implements ProjetDAO {
    @Override
    public Projet findOne(int id) throws SQLException {
        Projet projet = new Projet();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM projet WHERE id = ?");
            PreparedStatement pstm2=connection.prepareStatement("select * from task where PROJET_ID=?");
            PreparedStatement pstm3=connection.prepareStatement("select * from diagramme where PROJET_ID=?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                projet.setID(rs.getInt("ID"));
                projet.setTITLE("TITLE");
                projet.setDate((rs.getDate("DATE_DEBUT")));

                pstm2.setLong(1,rs.getLong("ID"));
                ResultSet rs2=pstm2.executeQuery();
                List<Task> tasks = new ArrayList<>();
                while(rs2.next()) {
                    Task t=new Task();
                    t.setID(rs2.getLong("ID"));
                    t.setDESCRIPTION(rs2.getString("DESCRIPTION"));
                    t.setDATE_DEBUT(rs2.getDate("DATE_DEBUT"));
                    t.setDATE_FIN(rs2.getDate("DATE_FIN"));
                    t.setTITLE(rs2.getString("TITLE"));
                    t.setPROJET(projet);
                    tasks.add(t);
                }
                projet.setTASKS(tasks);

                pstm3.setLong(1,rs.getLong("ID"));
                ResultSet rs3=pstm3.executeQuery();
                List<Diagramme> diagrammes = new ArrayList<>();
                while (rs3.next()){
                    Diagramme d=new Diagramme();
                    d.setID(rs3.getLong("ID"));
                    d.setTYPE(rs3.getString("TYPE"));
                    d.setPROJET(projet);
                    diagrammes.add(d);
                }
                projet.setDIAGRAMMES(diagrammes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projet;
    }

    @Override
    public List<Projet> findAll() throws SQLException {
        List<Projet> projets = new ArrayList<>();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select * from projet");
            PreparedStatement pstm2=connection.prepareStatement("select * from task where PROJET_ID=?");
            PreparedStatement pstm3=connection.prepareStatement("select * from diagramme where PROJET_ID=?");
            PreparedStatement pstm4=connection.prepareStatement("select * from user u INNER JOIN compte c ON u.ID = ? and u.COMPTE_ID = c.ID");
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                Projet p=new Projet();
                p.setID(rs.getInt("ID"));
                p.setTITLE(rs.getString("TITLE"));

                pstm4.setLong(1, rs.getLong("USER_ID"));
                ResultSet rs4=pstm.executeQuery();

                if(rs4.next()) {
                    Responsable responsable = new Responsable();
                    responsable.setID(rs4.getLong("ID"));
                    responsable.setCIN(rs4.getString("CIN"));
                    responsable.setIsResponsable(true);
                    responsable.setNOM(rs4.getString("NOM"));
                    responsable.setPRENOM(rs4.getString("PRENOM"));
                    responsable.setTEL(rs4.getString("TEL"));
                    responsable.setCOMPTE(new Compte( rs.getLong("COMPTE_ID"),rs4.getString("EMAIL") , rs4.getString("PASSWORD")));
                    p.setRESPONSABLE(responsable);
                }

                p.setDate(rs.getDate("DATE_DEBUT"));

                pstm2.setLong(1,rs.getLong("ID"));
                ResultSet rs2=pstm2.executeQuery();
                List<Task> tasks = new ArrayList<>();
                while (rs2.next()){
                    Task t=new Task();
                    t.setID(rs2.getLong("ID"));
                    t.setDESCRIPTION(rs2.getString("DESCRIPTION"));
                    t.setDATE_DEBUT(rs2.getDate("DATE_DEBUT"));
                    t.setDATE_FIN(rs2.getDate("DATE_FIN"));
                    t.setTITLE(rs2.getString("TITLE"));
                    t.setPROJET(p);
                    tasks.add(t);
                }
                p.setTASKS(tasks);

                pstm3.setLong(1,rs.getLong("ID"));
                ResultSet rs3=pstm3.executeQuery();
                List<Diagramme> diagrammes = new ArrayList<>();
                while (rs3.next()){
                    Diagramme d=new Diagramme();
                    d.setID(rs3.getLong("ID"));
                    d.setTYPE(rs3.getString("TYPE"));
                    d.setPROJET(p);
                    diagrammes.add(d);
                }
                p.setDIAGRAMMES(diagrammes);

                projets.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return projets;
    }

    @Override
    public Projet save(Projet p) throws SQLException {
        /*PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO projets (id, title, date, diagrammes, tasks, responsable) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setLong(1, p.getID());
            stmt.setString(2, p.getTITLE());
            stmt.setDate(3, (Date) p.getDate());*/
            /*stmt.setList(4, p.getDIAGRAMMES());
            stmt.setList(5, p.getTASKS());*/
            /*stmt.setObject(6, p.getRESPONSABLE());
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

        return p;*/
        return null;
    }

    @Override
    public boolean delete(Projet p) throws SQLException {
       /* PreparedStatement stmt = null;
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

        return false;*/
        return false;
    }

    @Override
    public Projet update(Projet p) throws SQLException {
        /*PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("UPDATE projets SET title = ?, date = ?, diagrammes = ?, tasks = ?, responsable = ? WHERE id = ?");
            stmt.setString(1, p.getTITLE());
            stmt.setDate(2, (Date) p.getDate());*/
           /* stmt.setList(3, p.getDIAGRAMMES());
            stmt.setList(4, p.getTASKS());*/
            /*stmt.setObject(5, p.getRESPONSABLE());
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

        return p;*/
        return null;
    }
}
