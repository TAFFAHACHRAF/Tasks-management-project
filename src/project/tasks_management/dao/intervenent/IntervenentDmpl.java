package project.tasks_management.dao.intervenent;

import project.tasks_management.dao.SingletonConnexionDB;
import project.tasks_management.dao.compte.CompteDmpl;
import project.tasks_management.entities.Compte;
import project.tasks_management.entities.Intervenent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IntervenentDmpl implements IntervenentDAO {
    @Override
    public List findAll() {
        List<Intervenent> intervenents = new ArrayList<>();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select * from user where isIntervenent=true");
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                Intervenent i=new Intervenent();
                i.setID(rs.getInt("ID"));
                i.setNOM(rs.getString("NOM"));
                i.setPRENOM(rs.getString("PRENOM"));
                i.setTEL(rs.getString("TEL"));
                i.getCOMPTE().setID(rs.getInt("COMPTE_ID"));
                intervenents.add(i);
            }
        }catch (SQLException e){
            return null;
        }
        return intervenents;
    }

    @Override
    public Intervenent findOne(int id) {
        Intervenent i=new Intervenent();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select * from user where isIntervenent=true and ID=?");
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
    public Intervenent save(Intervenent i) {
        PreparedStatement pstm=null;
        CompteDmpl cimpl=new CompteDmpl();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            Compte c=cimpl.save(i.getCOMPTE());
            // a revoir
            long COMPTE_ID=cimpl.getCompteByEmailAndPassword(c.getEMAIL(),c.getPASSWORD()).getID();

            pstm=connection.prepareStatement("insert into user (NOM,PRENOM,CIN,TEL,isResponsable,isIntervenent,COMPTE_ID) values (?,?,?,?,?,?,?)");
            pstm.setString(1,i.getNOM());
            pstm.setString(2,i.getPRENOM());
            pstm.setString(3,i.getCIN());
            pstm.setString(4,i.getTEL());
            pstm.setBoolean(5,i.getIsResponsable());
            pstm.setBoolean(6,i.getIsIntervenent());
            pstm.setLong(7, COMPTE_ID);
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public boolean delete(Intervenent i) {
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("delete user where ID=? and isIntervenent=true");
            pstm.setLong(1,i.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            return false;
        }
        return true;
    }

    @Override
    public Intervenent update(Intervenent i) {
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("update user set NOM=?,PRENOM=?,CIN=?,TEL=? where ID=? and isIntervenent=?");
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
