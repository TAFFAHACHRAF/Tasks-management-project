package project.tasks_management.dao.compte;

import project.tasks_management.dao.SingletonConnexionDB;
import project.tasks_management.entities.Compte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            return null;
        }
        return c;
    }

    @Override
    public List<Compte> findAll() {
        return null;
    }

    @Override
    public Compte findOne(int id) {
        return null;
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
        return getCompteByEmailAndPassword(c.getEMAIL(),c.getPASSWORD());
    }

    @Override
    public boolean delete(Compte c) {
        return false;
    }

    @Override
    public Compte update(Compte c) {
        return null;
    }
}
