package com.devops.task_management;

public class Todo {

    private long id;
    private String task;

    public Todo(long id, String task) {
        this.id = id;
        this.task = task;
    }

    public long getId() {
        return id;
    }

    public String getTask() {
        return task;
    }
}