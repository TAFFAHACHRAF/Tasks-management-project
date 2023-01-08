package project.tasks_management.dao.responsable;

import project.tasks_management.dao.SingletonConnexionDB;
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
                Responsable r=new Responsable();
                r.setID(rs.getInt("ID"));
                r.setNOM(rs.getString("NOM"));
                r.setPRENOM(rs.getString("PRENOM"));
                r.setCIN(rs.getString("CIN"));
                r.setTEL(rs.getString("TEL"));
                r.setEMAIL(rs.getString("EMAIL"));
                r.setPASSWORD(rs.getString("PASSWORD"));
                Responsables.add(r);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Responsables;
    }

    @Override
    public Responsable findOne(long id) {
        Responsable r=new Responsable();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select * from user where isResponsable=true and ID=?");
            pstm.setLong(1,id);
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){
                r.setID(rs.getInt("ID"));
                r.setNOM(rs.getString("NOM"));
                r.setPRENOM(rs.getString("PRENOM"));
                r.setCIN(rs.getString("CIN"));
                r.setTEL(rs.getString("TEL"));
                r.setEMAIL(rs.getString("EMAIL"));
                r.setPASSWORD(rs.getString("PASSWORD"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public Responsable save(Responsable r) {
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("insert into user (NOM,PRENOM,CIN,TEL,EMAIL,PASSWORD,true,false) values (?,?,?,?,?,?)");
            pstm.setString(1,r.getNOM());
            pstm.setString(2,r.getPRENOM());
            pstm.setString(3,r.getCIN());
            pstm.setString(4,r.getTEL());
            pstm.setString(5,r.getEMAIL());
            pstm.setString(6,r.getPASSWORD());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public boolean delete(Responsable r) {
        Connection connection=new SingletonConnexionDB().getConnexion();
        try {
            PreparedStatement pstm=connection.prepareStatement("delete user where ID=? and isResponsable=true");
            pstm.setLong(1,r.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Responsable update(Responsable r) {
        Connection connection=new SingletonConnexionDB().getConnexion();
        try {
            PreparedStatement pstm=connection.prepareStatement("update user set NOM=?,PRENOM=?,CIN=?,TEL=?,EMAIL=?,PASSWORD=? where ID=? and isResponsable=?");
            pstm.setString(1,r.getNOM());
            pstm.setString(2,r.getPRENOM());
            pstm.setString(3,r.getCIN());
            pstm.setString(4,r.getTEL());
            pstm.setString(5,r.getEMAIL());
            pstm.setString(6,r.getPASSWORD());
            pstm.setLong(7,r.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public Responsable getResponsablesByMateriel(Materiel m) {
        Responsable r = new Responsable();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select r.ID,r.NOM,r.PRENOM,r.CIN,r.TEL,r.EMAIL,r.PASSWORD from user r,materiel m where r.isResponsable=true and r.ID=m.RESPONSABLE_ID and m.RESPONSABLE_ID=?");
            pstm.setLong(1,m.getID());
            ResultSet rs=pstm.executeQuery();
            if (rs.next()){
                r.setID(rs.getInt("ID"));
                r.setNOM(rs.getString("NOM"));
                r.setPRENOM(rs.getString("PRENOM"));
                r.setCIN(rs.getString("CIN"));
                r.setTEL(rs.getString("TEL"));
                r.setEMAIL(rs.getString("EMAIL"));
                r.setPASSWORD(rs.getString("PASSWORD"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public Responsable getResponsablesByProjet(Projet p) {
        Responsable r=new Responsable();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select r.ID,r.NOM,r.PRENOM,r.CIN,r.TEL,r.EMAIL,r.PASSWORD from user r,projet p where r.isResponsable=1 and r.ID=p.RESPONSABLE_ID and p.ID=?");
            pstm.setLong(1,p.getID());
            ResultSet rs=pstm.executeQuery();
            if (rs.next()){
                r.setID(rs.getInt("ID"));
                r.setNOM(rs.getString("NOM"));
                r.setPRENOM(rs.getString("PRENOM"));
                r.setCIN(rs.getString("CIN"));
                r.setTEL(rs.getString("TEL"));
                r.setEMAIL(rs.getString("EMAIL"));
                r.setPASSWORD(rs.getString("PASSWORD"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return r;
    }
}
