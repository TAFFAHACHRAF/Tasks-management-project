package project.tasks_management.dao.order_de_travail;


import project.tasks_management.dao.Dao;
import project.tasks_management.entities.OrderDeTravail;
import project.tasks_management.entities.Task;

import java.util.List;

public interface OrderDeTravailDAO extends Dao<OrderDeTravail> {
    List<OrderDeTravail> getOrderDeTravailByTask(Task t);
}
