package project.tasks_management.services.order_de_travail;

import project.tasks_management.dao.order_de_travail.OrderDeTravailDmpl;
import project.tasks_management.entities.OrderDeTravail;
import project.tasks_management.entities.Task;
import project.tasks_management.services.Service;

import java.sql.SQLException;
import java.util.List;

public class order_de_travail implements order_de_travailService {
    OrderDeTravailDmpl odmpl=new OrderDeTravailDmpl();

    @Override
    public List<OrderDeTravail> retournerOrderDeTravails() throws SQLException {
        return odmpl.findAll();
    }

    @Override
    public OrderDeTravail retournerOrderDeTravailParId(OrderDeTravail o) throws SQLException {
        return odmpl.findOne(o.getID());
    }

    @Override
    public List<OrderDeTravail> retournerOrdersDeTravailParTask(Task t) throws SQLException {
        return odmpl.getOrderDeTravailByTask(t);
    }

    @Override
    public void ajouterOrderDeTravail(OrderDeTravail o) throws SQLException {
        odmpl.save(o);
    }

    @Override
    public void supprimerOrderDeTravail(OrderDeTravail o) throws SQLException {
        odmpl.delete(o);
    }

    @Override
    public void modifierOrderDeTravail(OrderDeTravail o) throws SQLException {
        odmpl.update(o);
    }

    @Override
    public void enregistrerOrderDeTravail(OrderDeTravail o) throws SQLException {
        odmpl.save(o);
    }
}
