package org.iti.app_tests;

import org.iti.app.Task;
import org.iti.app.TaskManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTests {
    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        resetTaskIdCounter();
        taskManager = new TaskManager();
    }

    private void resetTaskIdCounter() {
        try {
            Field nextTaskID = Task.class.getDeclaredField("nextTaskID");
            nextTaskID.setAccessible(true);
            nextTaskID.setInt(null, 0);
        } catch (Exception e) {
            fail("Failed to reset static task ID counter", e);
        }
    }

    @Test
    void testAddAndGetTask() {
        Task task = new Task("Test Task");
        taskManager.addTask(task);
        Task retrieved = taskManager.getTaskByID(0);
        assertNotNull(retrieved);
        assertEquals("Test Task", retrieved.getTaskDescription());
    }

    @Test
    void testRemoveTask() {
        Task task = new Task("Task to remove");
        taskManager.addTask(task);
        taskManager.removeTask(0);
        assertNull(taskManager.getTaskByID(0));
    }

    @Test
    void testGetAllTasks() {
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        List<Task> allTasks = taskManager.getAllTasks();
        assertEquals(2, allTasks.size());
        assertEquals(List.of(task1, task2), allTasks);
    }

    @Test
    void testUpdateTaskDescription() {
        Task task = new Task("Old Description");
        taskManager.addTask(task);
        taskManager.updateTaskDescription(0, "Updated Description");
        assertEquals("Updated Description", taskManager.getTaskByID(0).getTaskDescription());
    }

    @Test
    void testUpdateNonExistentTask() {
        var exception = assertThrowsExactly(IllegalArgumentException.class, () -> taskManager.updateTaskDescription(999, "No-op"));
        assertEquals("Task not found", exception.getMessage());
    }

    @Test
    void testRemoveNonExistentTask() {
        var exception = assertThrowsExactly(IllegalArgumentException.class, () -> taskManager.removeTask(999));
        assertEquals("Task not found", exception.getMessage());
    }

    @Test
    void testRemoveAllTasks() {
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        taskManager.removeAllTasks(List.of(0, 1));
        assertEquals(0, taskManager.getAllTasks().size());
    }

    @Test
    void testAddAllTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Bulk Task 1"));
        tasks.add(new Task("Bulk Task 2"));

        taskManager.addAllTasks(tasks);
        assertEquals(2, taskManager.getAllTasks().size());
        assertNotNull(taskManager.getTaskByID(0));
        assertNotNull(taskManager.getTaskByID(1));
    }

}
