package com.example.todoapp;
import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnect {

    public static Connection connectDatabase()  {
        String dbDriver="com.mysql.cj.jdbc.Driver";
        String dbURl="jdbc:mysql://localhost:3306/";

        String dbName="tasks";
        String dbUsername="root";
        String dbPassword="";
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection(dbURl + dbName,dbUsername,dbPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;

    }
}





