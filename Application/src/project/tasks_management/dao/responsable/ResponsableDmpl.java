package project.tasks_management.dao.Responsable;

import project.tasks_management.dao.SingletonConnexionDB;
import project.tasks_management.dao.compte.CompteDmpl;
import project.tasks_management.dao.responsable.ResponsableDAO;
import project.tasks_management.entities.Compte;
import project.tasks_management.entities.Responsable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResponsableDmpl implements ResponsableDAO {
    private Connection conn;

    public void AccountDao(SingletonConnexionDB conn) {
        this.conn = conn.getConnexion();
    }

    @Override
    public List findAll() {
        List<Responsable> Responsables = new ArrayList<>();
        try {
            PreparedStatement pstm=conn.prepareStatement("select * from user where isResponsable=true");
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
        Connection connection=new SingletonConnexionDB().getConnexion();
        try {
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
        Connection connection=new SingletonConnexionDB().getConnexion();
        PreparedStatement pstm=null;
        CompteDmpl cimpl=new CompteDmpl();
        try {
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
    public boolean delete(Responsable i) {
        Connection connection=new SingletonConnexionDB().getConnexion();
        try {
            PreparedStatement pstm=connection.prepareStatement("delete user where ID=?");
            pstm.setLong(1,i.getID());
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
}
