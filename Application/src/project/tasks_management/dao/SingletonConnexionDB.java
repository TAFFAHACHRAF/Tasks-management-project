package project.tasks_management.dao;

import java.sql.*;

public class SingletonConnexionDB {
    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tasks-management","root","");
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
    public Connection getConnexion(){
        return connection;
    }
}
