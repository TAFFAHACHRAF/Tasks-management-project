package project.tasks_management.services.order_de_travail;

import project.tasks_management.dao.order_de_travail.OrderDeTravailDmpl;
import project.tasks_management.entities.OrderDeTravail;
import project.tasks_management.services.Service;

import java.sql.SQLException;
import java.util.List;

public class order_de_travail implements Service<OrderDeTravail> {
    static OrderDeTravailDmpl odmpl;

    @Override
    public void add(OrderDeTravail orderDeTravail) throws SQLException {
        odmpl.save(orderDeTravail);
    }

    @Override
    public void delete(OrderDeTravail orderDeTravail) throws SQLException {
        odmpl.delete(orderDeTravail);
    }

    @Override
    public void update(OrderDeTravail orderDeTravail) throws SQLException {
        odmpl.update(orderDeTravail);
    }

    @Override
    public List<OrderDeTravail> get() throws SQLException {
        return odmpl.findAll();
    }
}
