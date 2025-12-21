

  import static org.junit.jupiter.api.Assertions.*;
  import org.junit.jupiter.api.Test;
  import java.util.Date;
  import java.util.Calendar;

  public class AppointmentTest {

      // Helper method to create a future date
      private Date getFutureDate() {
          Calendar calendar = Calendar.getInstance();
          calendar.add(Calendar.DAY_OF_MONTH, 1); // Add 1 day to current date
          return calendar.getTime();
      }

      // Helper method to create a past date
      private Date getPastDate() {
          Calendar calendar = Calendar.getInstance();
          calendar.add(Calendar.DAY_OF_MONTH, -1); // Subtract 1 day from current date
          return calendar.getTime();
      }

      @Test
      public void testValidAppointmentCreation() {
          // Test successful creation with valid inputs
          Date futureDate = getFutureDate();
          Appointment appointment = new
  Appointment("12345", futureDate, "Test appointment");

          assertEquals("12345",
  appointment.getAppointmentId());
          assertEquals(futureDate,
  appointment.getAppointmentDate());
          assertEquals("Test appointment",
  appointment.getDescription());
      }

      @Test
      public void testAppointmentIdNull() {
          // Test that null appointment ID throws exception
          Date futureDate = getFutureDate();
          assertThrows(IllegalArgumentException.class, ()
  -> {
              new Appointment(null, futureDate, "Test appointment");
          });
      }

      @Test
      public void testAppointmentIdTooLong() {
          // Test that appointment ID longer than 10 characters throws exception
          Date futureDate = getFutureDate();
          String longId = "12345678901"; // 11 characters
          assertThrows(IllegalArgumentException.class, ()
  -> {
              new Appointment(longId, futureDate, "Test appointment");
          });
      }

      @Test
      public void testAppointmentDateNull() {
          // Test that null appointment date throws exception
          assertThrows(IllegalArgumentException.class, ()
  -> {
              new Appointment("12345", null, "Test appointment");
          });
      }

      @Test
      public void testAppointmentDateInPast() {
          // Test that past appointment date throws exception
          Date pastDate = getPastDate();
          assertThrows(IllegalArgumentException.class, ()
  -> {
              new Appointment("12345", pastDate, "Test appointment");
          });
      }

      @Test
      public void testDescriptionNull() {
          // Test that null description throws exception
          Date futureDate = getFutureDate();
          assertThrows(IllegalArgumentException.class, ()
  -> {
              new Appointment("12345", futureDate, null);
          });
      }

      @Test
      public void testDescriptionTooLong() {
          // Test that description longer than 50 characters throws exception
          Date futureDate = getFutureDate();
          String longDescription = "This is a very long description that exceeds fifty characters";
          assertThrows(IllegalArgumentException.class, ()
  -> {
              new Appointment("12345", futureDate,
  longDescription);
          });
      }

      @Test
      public void testSetAppointmentDate() {
          // Test updating appointment date with valid future date
          Date futureDate1 = getFutureDate();
          Appointment appointment = new
  Appointment("12345", futureDate1, "Test appointment");

          Calendar calendar = Calendar.getInstance();
          calendar.add(Calendar.DAY_OF_MONTH, 2); //Different future date
          Date futureDate2 = calendar.getTime();

          appointment.setAppointmentDate(futureDate2);
          assertEquals(futureDate2,
  appointment.getAppointmentDate());
      }

      @Test
      public void testSetAppointmentDateInPast() {
          // Test that setting past date throws exception
          Date futureDate = getFutureDate();
          Appointment appointment = new
  Appointment("12345", futureDate, "Test appointment");
          Date pastDate = getPastDate();

          assertThrows(IllegalArgumentException.class, ()
  -> {
              appointment.setAppointmentDate(pastDate);
          });
      }

      @Test
      public void testSetDescription() {
          // Test updating description with valid text
          Date futureDate = getFutureDate();
          Appointment appointment = new
  Appointment("12345", futureDate, "Original description");

          appointment.setDescription("Updated description");
          assertEquals("Updated description",
  appointment.getDescription());
      }

      @Test
      public void testSetDescriptionTooLong() {
          // Test that setting description longer than 50 characters throws exception
          Date futureDate = getFutureDate();
          Appointment appointment = new
  Appointment("12345", futureDate, "Test appointment");
          String longDescription = "This is a very long description that exceeds fifty characters";

          assertThrows(IllegalArgumentException.class, ()
  -> {
              appointment.setDescription(longDescription);
          });
      }
  }