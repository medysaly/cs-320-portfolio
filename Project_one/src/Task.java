 public class Task {
      private final String taskId;  // final makes it unchangeable after construction
      private String name;
      private String description;

      // Constructor with validation
      public Task(String taskId, String name, String 
  description) {
          // Validate taskId
          if (taskId == null || taskId.length() > 10) {
              throw new IllegalArgumentException("Task ID cannot be null and must be 10 characters or less");
          }

          // Validate name
          if (name == null || name.length() > 20) {
              throw new IllegalArgumentException("Name cannot be null and must be 20 characters or less");
          }

          // Validate description
          if (description == null || description.length() >
   50) {
              throw new
  IllegalArgumentException("Description cannot be null and must be 50 characters or less");
          }

          this.taskId = taskId;
          this.name = name;
          this.description = description;
      }

      // Getters for all fields
      public String getTaskId() {
          return taskId;
      }

      public String getName() {
          return name;
      }

      public String getDescription() {
          return description;
      }

      // Setters only for name and description (NOT taskId)
      public void setName(String name) {
          if (name == null || name.length() > 20) {
              throw new IllegalArgumentException("Name cannot be null and must be 20 characters or less");
          }
          this.name = name;
      }

      public void setDescription(String description) {
          if (description == null || description.length() >
   50) {
              throw new
  IllegalArgumentException("Description cannot be null and must be 50 characters or less");
          }
          this.description = description;
      }
  }
