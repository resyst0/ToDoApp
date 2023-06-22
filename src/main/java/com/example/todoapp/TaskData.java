package com.example.todoapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskData {



    public List<Task> getData() throws SQLException, ClassNotFoundException {
        List<Task> tasks = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            connection = DatabaseConnect.connectDatabase();
            String sql = "SELECT * FROM tasktablo";
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while(result.next()) {

                String tasktitle=result.getString("tasktitle");
                String description=result.getString("description");
                String priority=result.getString("priority");

                Task task1=new Task(tasktitle,description,priority);
                tasks.add(task1);


            }

        }
        finally {
            closeConnection(connection,statement,result);
        }

        return tasks;
    }
    private void closeConnection(Connection connection, Statement statement, ResultSet result){
        try {
            if(connection!=null) {
                connection.close();
            }
            if(statement!=null) {
                statement.close();
            }
            if(result!=null) {
                result.close();
            }
        }catch (Exception exc) {
            exc.printStackTrace();
        }

    }
    public void addTask(Task task) {

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        try {
            connection=DatabaseConnect.connectDatabase();
            String sql="INSERT INTO tasktablo (tasktitle,description,priority) VALUES (?,?,?)";

            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,task.getTaskTitle());
            preparedStatement.setString(2,task.getPriority());
            preparedStatement.setString(3,task.getDescription());
            preparedStatement.execute();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public void deleteTask(int id)  {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            connection=DatabaseConnect.connectDatabase();
            String sql="DELETE FROM tasktablo WHERE id=?";
            statement= connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    }

