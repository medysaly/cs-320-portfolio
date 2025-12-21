import java.util.HashMap;
  import java.util.Map;

  public class TaskService {
      private Map<String, Task> tasks;

      public TaskService() {
          this.tasks = new HashMap<>();
      }

      // Add task with unique ID validation
      public boolean addTask(Task task) {
          if (task == null) {
              throw new IllegalArgumentException("Task cannot be null");
          }

          // Check if ID already exists
          if (tasks.containsKey(task.getTaskId())) {
              return false; // ID already exists, cannot add
          }

          tasks.put(task.getTaskId(), task);
          return true; // Successfully added
      }

      // Delete task by ID
      public boolean deleteTask(String taskId) {
          if (taskId == null) {
              return false;
          }

          Task removedTask = tasks.remove(taskId);
          return removedTask != null; // Returns true if task was found and removed
      }

      // Update task name by ID
      public boolean updateTaskName(String taskId, String 
  newName) {
          if (taskId == null) {
              return false;
          }

          Task task = tasks.get(taskId);
          if (task == null) {
              return false; // Task not found
          }

          try {
              task.setName(newName); // Uses Task's validation
              return true;
          } catch (IllegalArgumentException e) {
              return false; // Invalid name provided
          }
      }

      // Update task description by ID
      public boolean updateTaskDescription(String taskId, 
  String newDescription) {
          if (taskId == null) {
              return false;
          }

          Task task = tasks.get(taskId);
          if (task == null) {
              return false; // Task not found
          }

          try {
              task.setDescription(newDescription); // Uses Task's validation
              return true;
          } catch (IllegalArgumentException e) {
              return false; // Invalid description provided
          }
      }

  }
