package org.iti.app;

public class Task {
    private static int nextTaskID = 0;
    private final int taskID;
    private String taskDescription;

    public Task(String taskDescription) {
        this.taskID = nextTaskID++;
        this.taskDescription = taskDescription;
    }

    public int getTaskID() {
        return taskID;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}
