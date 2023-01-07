package project.tasks_management.services.notification;

import project.tasks_management.entities.Intervenant;
import project.tasks_management.entities.Notification;
import project.tasks_management.entities.Task;
import project.tasks_management.services.Service;

import java.sql.SQLException;
import java.util.List;

public interface notificationService extends Service<Notification> {
    public List<Notification> retournerNotifications() throws SQLException;
    public Notification retournerNotificationParId(Notification n) throws SQLException;
    public List<Notification> retournerNotificationsParTask(Task t) throws SQLException;
    public List<Notification> retournerNotificationsParIntervenant(Intervenant i) throws SQLException;
    public void ajouterNotification(Notification n) throws SQLException;

    public void supprimerNotification(Notification n) throws SQLException;

    public void modifierNotification(Notification n) throws SQLException;
    public void enregistrerNotification(Notification n) throws SQLException;
}
