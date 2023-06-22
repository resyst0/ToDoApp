package com.example.todoapp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
@WebServlet(name = "TaskServlet", value = "/TaskServlet")

public class TaskServlet extends HttpServlet  {

    private TaskData taskData = new TaskData();


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
         List<Task> tasks;

        {
            try {
                tasks = taskData.getData();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        request.setAttribute("tasklist", tasks);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/DENE.jsp");

        requestDispatcher.forward(request, response);
    }



    public void destroy() {
    }
}