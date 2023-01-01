package project.tasks_management.dao.intervenant;

import project.tasks_management.dao.SingletonConnexionDB;
import project.tasks_management.entities.Intervenant;
import project.tasks_management.entities.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IntervenantDmpl implements IntervenantDAO {
    @Override
    public List findAll() {
        List<Intervenant> Intervenants = new ArrayList<>();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select * from user where isIntervenant=true");
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                Intervenant i=new Intervenant();
                i.setID(rs.getInt("ID"));
                i.setNOM(rs.getString("NOM"));
                i.setPRENOM(rs.getString("PRENOM"));
                i.setTEL(rs.getString("TEL"));
                i.setEMAIL(rs.getString("EMAIL"));
                i.setPASSWORD(rs.getString("PASSWORD"));
                Intervenants.add(i);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Intervenants;
    }

    @Override
    public Intervenant findOne(int id) {
        Intervenant i=new Intervenant();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select * from user where isIntervenant=true and ID=?");
            pstm.setInt(1,id);
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){
                i.setID(rs.getInt("ID"));
                i.setNOM(rs.getString("NOM"));
                i.setPRENOM(rs.getString("PRENOM"));
                i.setTEL(rs.getString("TEL"));
                i.setEMAIL(rs.getString("EMAIL"));
                i.setPASSWORD(rs.getString("PASSWORD"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public Intervenant save(Intervenant i) {
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("insert into user (NOM,PRENOM,CIN,TEL,EMAIL,PASSWORD,isResponsable,isIntervenant) values (?,?,?,?,?,?,false,true)");
            pstm.setString(1,i.getNOM());
            pstm.setString(2,i.getPRENOM());
            pstm.setString(3,i.getCIN());
            pstm.setString(4,i.getTEL());
            pstm.setString(5,i.getEMAIL());
            pstm.setString(6,i.getPASSWORD());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public boolean delete(Intervenant i) {
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("delete user where ID=? and isIntervenant=true");
            pstm.setLong(1,i.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Intervenant update(Intervenant i) {
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("update user set NOM=?,PRENOM=?,CIN=?,TEL=?,EMAIL=?,PASSWORD=? where ID=? and isIntervenant=true");
            pstm.setString(1,i.getNOM());
            pstm.setString(2,i.getPRENOM());
            pstm.setString(3,i.getCIN());
            pstm.setString(4,i.getTEL());
            pstm.setString(5,i.getEMAIL());
            pstm.setString(6,i.getPASSWORD());
            pstm.setLong(7,i.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public List<Intervenant> getIntervenantsByTask(Task t){
        List<Intervenant> Intervenants = new ArrayList<>();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select r.ID,r.NOM,r.PRENOM,r.CIN,r.TEL,r.EMAIL,r.PASSWORD from user i,task t where i.isIntervenant=true and i.ID=t.INTERVENANT_ID and pt.INTERVENANT_ID=?");
            pstm.setLong(1,t.getID());
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                Intervenant i=new Intervenant();
                i.setID(rs.getInt("ID"));
                i.setNOM(rs.getString("NOM"));
                i.setPRENOM(rs.getString("PRENOM"));
                i.setTEL(rs.getString("TEL"));
                i.setEMAIL(rs.getString("EMAIL"));
                i.setPASSWORD(rs.getString("PASSWORD"));
                Intervenants.add(i);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Intervenants;
    }

}
