package project.tasks_management.dao.notification;

import project.tasks_management.dao.Dao;
import project.tasks_management.entities.*;

import java.util.List;

public interface NotificationDAO extends Dao<Notification> {
   public List<Notification> getNotificationByTask(Task t);
   public List<Notification> getNotificationByIntervenant(Intervenant i);
}
