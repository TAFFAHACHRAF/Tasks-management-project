package project.tasks_management.dao.materiel;

import project.tasks_management.dao.SingletonConnexionDB;
import project.tasks_management.entities.Materiel;
import project.tasks_management.entities.Responsable;
import project.tasks_management.entities.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialDmpl implements MaterialDAO {
    @Override
    public List<Materiel> findAll() throws SQLException {
        List<Materiel> Materiels = new ArrayList<>();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select * from materiel");
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                Materiel m=new Materiel();
                m.setID(rs.getLong("ID"));
                m.setTYPE(rs.getString("TYPE"));
                m.setNOM(rs.getString("NOM"));
                Materiels.add(m);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Materiels;
    }

    @Override
    public Materiel findOne(int id) throws SQLException {
        Materiel m=new Materiel();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select * from materiel where ID=?");
            pstm.setLong(1,id);
            ResultSet rs=pstm.executeQuery();
            if (rs.next()){
                m.setID(rs.getLong("ID"));
                m.setTYPE(rs.getString("TYPE"));
                m.setNOM(rs.getString("NOM"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return m;
    }

    @Override
    public Materiel save(Materiel m) throws SQLException {
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("insert into materiel (ID,TYPE,NOM,RESPONSABLE_ID,TASK_ID) values (?,?,?,?,?)");
            pstm.setLong(1,m.getID());
            pstm.setString(2,m.getTYPE());
            pstm.setString(3,m.getNOM());
            pstm.setLong(4,m.getRESPONSABLE().getID());
            //pstm.setLong(5,m.getTASK().getId());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return m;
    }

    @Override
    public boolean delete(Materiel m) throws SQLException {
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("delete materiel where ID=?");
            pstm.setLong(1,m.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Materiel update(Materiel m) throws SQLException {
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("update materiel set ID=?,TYPE=?,NOM=?,RESPONSABLE_ID=?,TASK_ID=? where ID=?");
            pstm.setString(1,m.getTYPE());
            pstm.setString(2,m.getNOM());
            pstm.setLong(3,m.getRESPONSABLE().getID());
            pstm.setLong(4,0); // task id
            pstm.setLong(5,m.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return m;
    }

    @Override
    public List<Materiel> getMaterielsByResponsable(Responsable r){
        List<Materiel> Materiels = new ArrayList<>();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select m.ID,m.TYPE,m.NOM,m.RESPONSABLE_ID,m.TASK_ID from materiel m,user r where m.RESPONSABLE_ID=r.ID,r.ID=?");
            pstm.setLong(1,r.getID());
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                Materiel m=new Materiel();
                m.setID(rs.getLong("ID"));
                m.setTYPE(rs.getString("TYPE"));
                m.setNOM(rs.getString("NOM"));
                Materiels.add(m);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Materiels;
    }

    @Override
    public List<Materiel> getMaterielsByTask(Task t){
        List<Materiel> Materiels = new ArrayList<>();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select m.ID,m.TYPE,m.NOM,m.RESPONSABLE_ID,m.TASK_ID from materiel m,task t where m.TASK_ID=r.ID,t.ID=?");
            pstm.setLong(1,t.getID());
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                Materiel m=new Materiel();
                m.setID(rs.getLong("ID"));
                m.setTYPE(rs.getString("TYPE"));
                m.setNOM(rs.getString("NOM"));
                Materiels.add(m);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Materiels;
    }
}