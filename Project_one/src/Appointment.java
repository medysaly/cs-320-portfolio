

 import java.util.Date;

  public class Appointment {
      private final String appointmentId;
      private Date appointmentDate;
      private String description;

      // Constructor with validation
      public Appointment(String appointmentId, Date 
  appointmentDate, String description) {
          // Validate appointmentId
          if (appointmentId == null) {
              throw new
  IllegalArgumentException("Appointment ID cannot be null");
          }
          if (appointmentId.length() > 10) {
              throw new
  IllegalArgumentException("Appointment ID cannot exceed 10 characters");
          }

          // Validate appointmentDate
          if (appointmentDate == null) {
              throw new
  IllegalArgumentException("Appointment date cannot be null");
          }
          if (appointmentDate.before(new Date())) {
              throw new
  IllegalArgumentException("Appointment date cannot be in the past");
          }

          // Validate description
          if (description == null) {
              throw new
  IllegalArgumentException("Description cannot be null");
          }
          if (description.length() > 50) {
              throw new
  IllegalArgumentException("Description cannot exceed 50 characters");
          }

          // If all validations pass, set the fields
          this.appointmentId = appointmentId;
          this.appointmentDate = appointmentDate;
          this.description = description;
      }

      // Getters for all fields
      public String getAppointmentId() {
          return appointmentId;
      }

      public Date getAppointmentDate() {
          return appointmentDate;
      }

      public String getDescription() {
          return description;
      }

      // Setter for appointmentDate (with validation)
      public void setAppointmentDate(Date appointmentDate) 
  {
          if (appointmentDate == null) {
              throw new
  IllegalArgumentException("Appointment date cannot be null");
          }
          if (appointmentDate.before(new Date())) {
              throw new
  IllegalArgumentException("Appointment date cannot be in the past");
          }
          this.appointmentDate = appointmentDate;
      }

      // Setter for description (with validation)
      public void setDescription(String description) {
          if (description == null) {
              throw new
  IllegalArgumentException("Description cannot be null");
          }
          if (description.length() > 50) {
              throw new
  IllegalArgumentException("Description cannot exceed 50 characters");
          }
          this.description = description;
      }

      
  }