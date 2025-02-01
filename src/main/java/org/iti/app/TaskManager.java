package org.iti.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {
    private Map<Integer, Task> tasks;

    public TaskManager() {
        tasks = new HashMap<>();
    }

    public void addTask(Task task) {
        tasks.put(task.getTaskID(), task);
    }

    public void removeTask(int taskID)  {
        if(tasks.containsKey(taskID))
            tasks.remove(taskID);
        else throw new IllegalArgumentException("Task not found");
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public void updateTaskDescription(int taskID, String newDescription) {
        Task task = tasks.get(taskID);
        if (task != null) {
            task.setTaskDescription(newDescription);
        } else throw new IllegalArgumentException("Task not found");
    }

    public Task getTaskByID(int taskID) {
        return tasks.get(taskID);
    }

    public void removeAllTasks(List<Integer> taskIDs) {
        for (int id : taskIDs) {
            tasks.remove(id);
        }
    }

    public void addAllTasks(List<Task> tasksToAdd) {
        for (Task task : tasksToAdd) {
            addTask(task);
        }
    }
}
