package project.tasks_management.dao.compte;

import project.tasks_management.dao.SingletonConnexionDB;
import project.tasks_management.entities.Compte;
import project.tasks_management.entities.Intervenent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompteDmpl implements CompteDAO {
    @Override
    public Compte getCompteByEmailAndPassword(String email, String password) {
        Compte c=new Compte();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select * from compte where EMAIL=? and PASSWORD=?");
            pstm.setString(1,email);
            pstm.setString(2,password);
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){
                c.setID(rs.getInt("ID"));
                c.setEMAIL(rs.getString("EMAIL"));
                c.setPASSWORD(rs.getString("PASSWORD"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public List<Compte> findAll() throws SQLException {
        Connection connection=new SingletonConnexionDB().getConnexion();
        PreparedStatement pstm=connection.prepareStatement("select * from compte");
        List<Compte> comptes = new ArrayList<>();
        ResultSet rs=pstm.executeQuery();
        try {
            while (rs.next()){
                Compte c=new Compte();
                c.setID(rs.getInt("ID"));
                c.setEMAIL(rs.getString("EMAIL"));
                c.setPASSWORD(rs.getString("PASSWORD"));
                comptes.add(c);
            }
        }catch (SQLException e){
            return null;
        }
        return comptes;
    }

    @Override
    public Compte findOne(int id) {
        Connection connection=new SingletonConnexionDB().getConnexion();
        Compte c=new Compte();
        try {
            PreparedStatement pstm=connection.prepareStatement("select * from compte where ID=?");
            pstm.setLong(1,id);
            ResultSet rs=pstm.executeQuery();
            if (rs.next()){
                c.setID(rs.getInt("ID"));
                c.setEMAIL(rs.getString("EMAIL"));
                c.setPASSWORD(rs.getString("PASSWORD"));
            }
        }catch (SQLException e){
            return null;
        }
        return c;
    }

    @Override
    public Compte save(Compte c) {
        try {
            Connection connection = new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm = connection.prepareStatement("insert into compte values (0,?,?)");
            pstm.setString(1, c.getEMAIL());
            pstm.setString(2, c.getPASSWORD());
            pstm.executeUpdate();
        } catch (SQLException e){
            return null;
        }
        return c;
    }

    @Override
    public boolean delete(Compte c) {
        Connection connection=new SingletonConnexionDB().getConnexion();
        try {
            PreparedStatement pstm=connection.prepareStatement("delete from compte where ID=?");
            pstm.setLong(1,c.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            return false;
        }
        return true;
    }

    @Override
    public Compte update(Compte c) {
        Connection connection=new SingletonConnexionDB().getConnexion();
        try {
            PreparedStatement pstm=connection.prepareStatement("update compte set EMAIL=?,PASSWORD=? where ID=?");
            pstm.setString(1,c.getEMAIL());
            pstm.setString(2,c.getPASSWORD());
            pstm.setLong(3,c.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            return null;
        }
        return c;
    }
}
