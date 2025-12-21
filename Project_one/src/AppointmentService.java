

  import java.util.HashMap;
  import java.util.Map;

  public class AppointmentService {
      private Map<String, Appointment> appointments;

      // Constructor
      public AppointmentService() {
          this.appointments = new HashMap<>();
      }

      // Add appointment with unique ID validation
      public void addAppointment(Appointment appointment) {
          if (appointment == null) {
              throw new
  IllegalArgumentException("Appointment cannot be null");
          }

          String appointmentId =
  appointment.getAppointmentId();

          // Check if appointment ID already exists
          if (appointments.containsKey(appointmentId)) {
              throw new
  IllegalArgumentException("Appointment with ID " +
  appointmentId + " already exists");
          }

          // Add the appointment to the map
          appointments.put(appointmentId, appointment);
      }

      // Delete appointment by ID
      public void deleteAppointment(String appointmentId) {
          if (appointmentId == null) {
              throw new
  IllegalArgumentException("Appointment ID cannot be null");
          }

          // Check if appointment exists before deleting
          if (!appointments.containsKey(appointmentId)) {
              throw new
  IllegalArgumentException("Appointment with ID " +
  appointmentId + " does not exist");
          }

          // Remove the appointment from the map
          appointments.remove(appointmentId);
      }

      // Helper method to get an appointment by ID (useful for testing)
      public Appointment getAppointment(String 
  appointmentId) {
          return appointments.get(appointmentId);
      }

      // Helper method to get the number of appointments(useful for testing)
      public int getAppointmentCount() {
          return appointments.size();
      }

      // Helper method to check if an appointment exists (useful for testing)
      public boolean appointmentExists(String 
  appointmentId) {
          return appointments.containsKey(appointmentId);
      }
  }
