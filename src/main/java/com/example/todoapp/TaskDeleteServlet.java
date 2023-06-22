package com.example.todoapp;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TaskDeleteServlet", value = "/TaskDeleteServlet")
public class TaskDeleteServlet extends HttpServlet {
 private TaskData taskData=new TaskData();



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try{
        String id1=request.getParameter("id");
            taskData.deleteTask(Integer.parseInt(id1));
            response.sendRedirect(request.getContextPath()+"/TaskServlet");
        }
        catch (Exception ex) {
        throw new RuntimeException();
    }


}

    public void destroy() {
    }
}