package com.example.todoapp;

public class Task {
    public Task(String taskTitle, String description,String priority) {
        this.taskTitle = taskTitle;
        this.description = description;
        this.priority = priority;
    }

    public Task(int id, String taskTitle, String description, String priority) {
        this.id = id;
        this.taskTitle = taskTitle;
        this.description = description;
        this.priority = priority;
    }

    private int id;
    private String taskTitle;
    private String description;
    private String priority;

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setTask(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
