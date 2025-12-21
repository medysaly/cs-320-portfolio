 import static org.junit.jupiter.api.Assertions.*;
  import org.junit.jupiter.api.BeforeEach;
  import org.junit.jupiter.api.Test;

  public class TaskServiceTest {

      private TaskService taskService;

      @BeforeEach
      public void setUp() {
          taskService = new TaskService();
      }

      @Test
      public void testAddTaskWithUniqueId() {
          // Test adding tasks with unique IDs
          Task task1 = new Task("123", "Task One",
  "Description One");
          Task task2 = new Task("456", "Task Two",
  "Description Two");

          assertTrue(taskService.addTask(task1));
          assertTrue(taskService.addTask(task2));
      }

      @Test
      public void testAddTaskWithDuplicateId() {
          // Test that duplicate IDs are rejected
          Task task1 = new Task("123", "First Task", "First Description");
          Task task2 = new Task("123", "Second Task",
  "Second Description");

          assertTrue(taskService.addTask(task1));
          assertFalse(taskService.addTask(task2)); //Should fail due to duplicate ID
      }

      @Test
      public void testDeleteTask() {
          // Test deleting task by ID
          Task task = new Task("123", "Test Task", "Test Description");
          taskService.addTask(task);

          assertTrue(taskService.deleteTask("123"));
          assertFalse(taskService.deleteTask("999")); // Non-existent task
      }

      @Test
      public void testUpdateTaskName() {
          // Test updating task name by ID
          Task task = new Task("123", "Original Name",
  "Description");
          taskService.addTask(task);

          assertTrue(taskService.updateTaskName("123",
  "Updated Name"));
          assertFalse(taskService.updateTaskName("999",
  "New Name")); // Non-existent task
      }

      @Test
      public void testUpdateTaskDescription() {
          // Test updating task description by ID
          Task task = new Task("123", "Name", "Original Description");
          taskService.addTask(task);


  assertTrue(taskService.updateTaskDescription("123",
  "Updated Description"));

  assertFalse(taskService.updateTaskDescription("999", "New Description")); // Non-existent task
      }
  }