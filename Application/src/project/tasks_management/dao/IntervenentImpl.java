package project.tasks_management.dao;

import project.tasks_management.dao.entities.Compte;
import project.tasks_management.dao.entities.Intervenent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IntervenentImpl implements IntervenentInterface {
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
        Connection connection=new SingletonConnexionDB().getConnexion();
        try {
            PreparedStatement pstm=connection.prepareStatement("select * from user where isIntervenent=true and ID=?");
            pstm.setInt(1,id);
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){
                i.setID(rs.getInt("ID"));
                i.setNOM(rs.getString("NOM"));
                i.setPRENOM(rs.getString("PRENOM"));
                i.setTEL(rs.getString("TEL"));
                i.getCOMPTE().setID(rs.getInt("COMPTE_ID"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public Intervenent save(Intervenent i) {
        Connection connection=new SingletonConnexionDB().getConnexion();
        try {
            CompteImpl cimpl=new CompteImpl();
            Compte c=cimpl.save(i.getCOMPTE());
            long COMPTE_ID=cimpl.getCompteByEmailAndPassword(c.getEMAIL(),c.getPASSWORD()).getID();

            PreparedStatement pstm=connection.prepareStatement("insert into user (NOM,PRENOM,CIN,TEL,isResponsable,isIntervenent,COMPTE_ID) values (?,?,?,?,?,?,?)");
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
        return false;
    }

    @Override
    public Intervenent update(Intervenent i) {
        return null;
    }

    @Override
    public void show() {

    }
}
