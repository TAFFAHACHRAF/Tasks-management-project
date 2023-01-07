package project.tasks_management.services.notification;

import project.tasks_management.dao.notification.NotificationDmpl;
import project.tasks_management.entities.Intervenant;
import project.tasks_management.entities.Notification;
import project.tasks_management.entities.Task;
import project.tasks_management.services.Service;
import project.tasks_management.services.materiel.materielService;

import java.sql.SQLException;
import java.util.List;

public class notification implements notificationService {
    NotificationDmpl ndmpl=new NotificationDmpl();

    @Override
    public List<Notification> retournerNotifications() throws SQLException {
        return ndmpl.findAll();
    }

    @Override
    public Notification retournerNotificationParId(Notification n) throws SQLException {
        return ndmpl.findOne(n.getID());
    }

    @Override
    public List<Notification> retournerNotificationsParTask(Task t) throws SQLException {
        return ndmpl.getNotificationByTask(t);
    }

    @Override
    public List<Notification> retournerNotificationsParIntervenant(Intervenant i) throws SQLException {
        return ndmpl.getNotificationByIntervenant(i);
    }

    @Override
    public void ajouterNotification(Notification n) throws SQLException {
        ndmpl.save(n);
    }

    @Override
    public void supprimerNotification(Notification n) throws SQLException {
        ndmpl.delete(n);
    }

    @Override
    public void modifierNotification(Notification n) throws SQLException {
        ndmpl.update(n);
    }

    @Override
    public void enregistrerNotification(Notification n) throws SQLException {
        ndmpl.save(n);
    }
}
