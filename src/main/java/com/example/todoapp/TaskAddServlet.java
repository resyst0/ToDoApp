package com.example.todoapp;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addTaskServlet", value = "/add-servlet")
public class TaskAddServlet extends HttpServlet {
    private String message;

private TaskData taskData=new TaskData();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        try {
            String title = request.getParameter("tasktitle");
            String description = request.getParameter("description");
            String priority = request.getParameter("priority");

            Task task = new Task(title, description, priority);

            taskData.addTask(task);

            response.sendRedirect(request.getContextPath() + "/TaskServlet");

        } catch (Exception ex) {
            throw new RuntimeException();
        }


    }
    public void destroy(){
    }

}