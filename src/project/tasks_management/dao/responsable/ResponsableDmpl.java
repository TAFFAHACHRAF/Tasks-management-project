package project.tasks_management.dao.responsable;

import project.tasks_management.dao.SingletonConnexionDB;
import project.tasks_management.dao.compte.CompteDmpl;
import project.tasks_management.dao.responsable.ResponsableDAO;
import project.tasks_management.entities.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResponsableDmpl implements ResponsableDAO {

    @Override
    public List findAll() {
        List<Responsable> Responsables = new ArrayList<>();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select * from user where isResponsable=true");
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                Responsable i=new Responsable();
                i.setID(rs.getInt("ID"));
                i.setNOM(rs.getString("NOM"));
                i.setPRENOM(rs.getString("PRENOM"));
                i.setTEL(rs.getString("TEL"));
                i.getCOMPTE().setID(rs.getInt("COMPTE_ID"));
                Responsables.add(i);
            }
        }catch (SQLException e){
            return null;
        }
        return Responsables;
    }

    @Override
    public Responsable findOne(int id) {
        Responsable i=new Responsable();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select * from user where isResponsable=true and ID=?");
            pstm.setInt(1,id);
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){
                i.setID(rs.getInt("ID"));
                i.setNOM(rs.getString("NOM"));
                i.setPRENOM(rs.getString("PRENOM"));
                i.setTEL(rs.getString("TEL"));
                CompteDmpl cdmp=new CompteDmpl();
                i.setCOMPTE(cdmp.findOne(rs.getInt("COMPTE_ID")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public Responsable save(Responsable i) {
        PreparedStatement pstm=null;
        CompteDmpl cimpl=new CompteDmpl();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            Compte c=cimpl.save(i.getCOMPTE());
            long COMPTE_ID=cimpl.getCompteByEmailAndPassword(c.getEMAIL(),c.getPASSWORD()).getID();

            pstm=connection.prepareStatement("insert into user (NOM,PRENOM,CIN,TEL,isResponsable,isResponsable,COMPTE_ID) values (?,?,?,?,?,?,?)");
            pstm.setString(1,i.getNOM());
            pstm.setString(2,i.getPRENOM());
            pstm.setString(3,i.getCIN());
            pstm.setString(4,i.getTEL());
            pstm.setBoolean(5,i.getIsResponsable());
            pstm.setBoolean(6,i.getIsResponsable());
            pstm.setLong(7, COMPTE_ID);
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public boolean delete(Responsable r) {
        Connection connection=new SingletonConnexionDB().getConnexion();
        try {
            PreparedStatement pstm=connection.prepareStatement("delete user where ID=? and isResponsable=true");
            pstm.setLong(1,r.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            return false;
        }
        return true;
    }

    @Override
    public Responsable update(Responsable i) {
        Connection connection=new SingletonConnexionDB().getConnexion();
        try {
            PreparedStatement pstm=connection.prepareStatement("update user set NOM=?,PRENOM=?,CIN=?,TEL=? where ID=? and isResponsable=?");
            pstm.setString(1,i.getNOM());
            pstm.setString(2,i.getPRENOM());
            pstm.setString(3,i.getCIN());
            pstm.setString(4,i.getTEL());
            pstm.setLong(5,i.getID());
            pstm.setBoolean(5,i.getIsResponsable());
            pstm.executeUpdate();
        }catch (SQLException e){
            return null;
        }
        return i;
    }

    @Override
    public List<Projet> getProjetsByReponsable(Responsable r) {
        List<Projet> projets = new ArrayList<>();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select * from projet where USER_ID=?");
            PreparedStatement pstm2=connection.prepareStatement("select * from task where PROJET_ID=?");
            PreparedStatement pstm3=connection.prepareStatement("select * from diagramme where PROJET_ID=?");
            pstm.setLong(1,r.getID());
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                Projet p=new Projet();
                p.setID(rs.getInt("ID"));
                p.setTITLE(rs.getString("TITLE"));
                p.setRESPONSABLE(r);
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
}
