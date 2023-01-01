package project.tasks_management.services.notification;

import project.tasks_management.dao.notification.NotificationDmpl;
import project.tasks_management.entities.Notification;
import project.tasks_management.services.Service;

import java.sql.SQLException;
import java.util.List;

public class notification implements Service<Notification> {
    static NotificationDmpl ndmpl;

    @Override
    public void add(Notification notification) throws SQLException {
        ndmpl.save(notification);
    }

    @Override
    public void delete(Notification notification) throws SQLException {
        ndmpl.delete(notification);
    }

    @Override
    public void update(Notification notification) throws SQLException {
        ndmpl.update(notification);
    }

    @Override
    public List<Notification> get() throws SQLException {
        return ndmpl.findAll();
    }
}
