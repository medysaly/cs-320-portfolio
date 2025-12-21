import static org.junit.jupiter.api.Assertions.*;
  import org.junit.jupiter.api.Test;

  public class TaskTest {

      @Test
      public void testValidTaskCreation() {
          // Test successful creation with valid inputs
          Task task = new Task("12345", "Valid Task", "This is a valid description");
          assertEquals("12345", task.getTaskId());
          assertEquals("Valid Task", task.getName());
          assertEquals("This is a valid description",
  task.getDescription());
      }

      @Test
      public void testTaskIdNull() {
          // Test that null taskId throws exception
          assertThrows(IllegalArgumentException.class, ()
  -> {
              new Task(null, "Valid Name", "Valid Description");
          });
      }

      @Test
      public void testTaskIdTooLong() {
          // Test that taskId longer than 10 characters throws exception
          assertThrows(IllegalArgumentException.class, ()
  -> {
              new Task("12345678901", "Valid Name", "Valid Description");
          });
      }

      @Test
      public void testNameNull() {
          // Test that null name throws exception
          assertThrows(IllegalArgumentException.class, ()
  -> {
              new Task("123", null, "Valid Description");
          });
      }

      @Test
      public void testNameTooLong() {
          // Test that name longer than 20 characters throws exception
          assertThrows(IllegalArgumentException.class, ()
  -> {
              new Task("123", "This name is way too long",
  "Valid Description");
          });
      }

      @Test
      public void testDescriptionNull() {
          // Test that null description throws exception
          assertThrows(IllegalArgumentException.class, ()
  -> {
              new Task("123", "Valid Name", null);
          });
      }

      @Test
      public void testDescriptionTooLong() {
          // Test that description longer than 50 characters throws exception
          assertThrows(IllegalArgumentException.class, ()
  -> {
              new Task("123", "Valid Name", "This description is way too long and exceeds the fifty character limit");
          });
      }

      @Test
      public void testTaskIdCannotBeUpdated() {
          // Test that taskId cannot be changed (no setter exists)
          Task task = new Task("123", "Name",
  "Description");
          assertEquals("123", task.getTaskId());

          // Verify taskId stays the same (since there's no setter)
          assertEquals("123", task.getTaskId());
      }

      @Test
      public void testUpdateName() {
          // Test updating name with valid value
          Task task = new Task("123", "Original",
  "Description");
          task.setName("Updated Name");
          assertEquals("Updated Name", task.getName());
      }

      @Test
      public void testUpdateNameInvalid() {
          // Test updating name with invalid value throws exception
          Task task = new Task("123", "Original",
  "Description");

          assertThrows(IllegalArgumentException.class, ()
  -> {
              task.setName(null);
          });

          assertThrows(IllegalArgumentException.class, ()
  -> {
              task.setName("This name is way too long");
          });
      }

      @Test
      public void testUpdateDescription() {
          // Test updating description with valid value
          Task task = new Task("123", "Name", "Original description");
          task.setDescription("Updated description");
          assertEquals("Updated description",
  task.getDescription());
      }

      @Test
      public void testUpdateDescriptionInvalid() {
          // Test updating description with invalid value throws exception
          Task task = new Task("123", "Name", "Original");

          assertThrows(IllegalArgumentException.class, ()
  -> {
              task.setDescription(null);
          });

          assertThrows(IllegalArgumentException.class, ()
  -> {
              task.setDescription("This description is way too long and exceeds the fifty character limit");
          });
      }
  }
