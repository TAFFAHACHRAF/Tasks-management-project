package project.tasks_management.dao.order_de_travail;

import project.tasks_management.dao.SingletonConnexionDB;
import project.tasks_management.dao.task.TaskDmpl;
import project.tasks_management.entities.OrderDeTravail;
import project.tasks_management.entities.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDeTravailDmpl implements OrderDeTravailDAO {
    @Override
    public List findAll() {
        List<OrderDeTravail> orders = new ArrayList<>();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select * from order_de_travail");
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                OrderDeTravail o=new OrderDeTravail();
                o.setID(rs.getInt("ID"));
                o.setTITLE(rs.getString("TITLE"));
                o.setDESCRIPTION(rs.getString("DESCRIPTION"));

                // affecter task
                TaskDmpl t=new TaskDmpl();
                if(t.getTaskByOrderDeTravail(o) != null) {
                    Task tt = t.getTaskByOrderDeTravail(o);
                    o.setTask(tt);
                }

                orders.add(o);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public OrderDeTravail findOne(long id) {
        OrderDeTravail o=new OrderDeTravail();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select * from order_de_travail where ID=?");
            pstm.setLong(1,id);
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){
                o.setID(rs.getInt("ID"));
                o.setTITLE(rs.getString("TITLE"));
                o.setDESCRIPTION(rs.getString("DESCRIPTION"));

                // affecter task
                TaskDmpl t=new TaskDmpl();
                if(t.getTaskByOrderDeTravail(o)!=null) {
                    Task tt = t.getTaskByOrderDeTravail(o);
                    o.setTask(tt);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public OrderDeTravail save(OrderDeTravail o) {
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("insert into order_de_travail (ID,TITLE,DESCRIPTION,TASK_ID) values (?,?,?,?)");
            pstm.setLong(1,o.getID());
            pstm.setString(2,o.getTITLE());
            pstm.setString(3,o.getDESCRIPTION());
            pstm.setLong(4,o.getTask().getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public boolean delete(OrderDeTravail o) {
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("delete order_de_travail where ID=?");
            pstm.setLong(1,o.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public OrderDeTravail update(OrderDeTravail o) {
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("update order_de_travail set DESCRIPTION=?,TITLE=? where ID=?");
            pstm.setString(1,o.getTITLE());
            pstm.setString(2,o.getDESCRIPTION());
            pstm.setLong(3,o.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public List<OrderDeTravail> getOrderDeTravailByTask(Task t){
        List<OrderDeTravail> orders = new ArrayList<>();
        try {
            Connection connection=new SingletonConnexionDB().getConnexion();
            PreparedStatement pstm=connection.prepareStatement("select o.ID,o.TITLE,o.DESCRIPTION,o.TASK_ID from order_de_travail o,task t where t.ID=o.TASK_ID and t.ID=?");
            pstm.setLong(1,t.getID());
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                OrderDeTravail o=new OrderDeTravail();
                o.setID(rs.getInt("ID"));
                o.setTITLE(rs.getString("TITLE"));
                o.setDESCRIPTION(rs.getString("DESCRIPTION"));
                o.setTask(t);
                orders.add(o);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return orders;
    }

}
