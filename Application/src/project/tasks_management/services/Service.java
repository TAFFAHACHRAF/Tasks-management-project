package project.tasks_management.services;

import java.sql.SQLException;
import java.util.List;

public interface Service <T>{
    public void add(T t) throws SQLException;

    public void delete(T t) throws SQLException;

    public void update(T t) throws SQLException;

    public List<T> get() throws SQLException;
}
