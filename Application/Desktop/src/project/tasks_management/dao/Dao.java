package project.tasks_management.dao;
import java.sql.SQLException;
import java.util.List;

public interface Dao <T>{
    List<T> findAll() throws SQLException;
    T findOne(long id) throws SQLException;
    T save(T o) throws SQLException;
    boolean delete(T o) throws SQLException;
    T update(T o) throws SQLException;
}
