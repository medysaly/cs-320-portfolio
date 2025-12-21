 

  import static org.junit.jupiter.api.Assertions.*;
  import org.junit.jupiter.api.BeforeEach;
  import org.junit.jupiter.api.Test;
  import java.util.Date;
  import java.util.Calendar;

  public class AppointmentServiceTest {

      private AppointmentService appointmentService;

      // Helper method to create a future date
      private Date getFutureDate() {
          Calendar calendar = Calendar.getInstance();
          calendar.add(Calendar.DAY_OF_MONTH, 1);
          return calendar.getTime();
      }

      @BeforeEach
      public void setUp() {
          // Create a fresh AppointmentService for each test
          appointmentService = new AppointmentService();
      }

      @Test
      public void testAddAppointment() {
          // Test adding a valid appointment
          Date futureDate = getFutureDate();
          Appointment appointment = new
  Appointment("12345", futureDate, "Test appointment");

          appointmentService.addAppointment(appointment);

          // Verify the appointment was added
          assertTrue(appointmentService.appointmentExists("12345"));
          assertEquals(1,
  appointmentService.getAppointmentCount());
          assertEquals(appointment,
  appointmentService.getAppointment("12345"));
      }

      @Test
      public void testAddMultipleAppointments() {
          // Test adding multiple appointments with different IDs
          Date futureDate = getFutureDate();
          Appointment appointment1 = new
  Appointment("12345", futureDate, "First appointment");
          Appointment appointment2 = new
  Appointment("67890", futureDate, "Second appointment");

          appointmentService.addAppointment(appointment1);
          appointmentService.addAppointment(appointment2);

          // Verify both appointments were added
          assertTrue(appointmentService.appointmentExists("12345"));
          assertTrue(appointmentService.appointmentExists("67890"));
          assertEquals(2,
  appointmentService.getAppointmentCount());
      }

      @Test
      public void testAddAppointmentWithDuplicateId() {
          // Test that adding appointment with duplicate ID throws exception
          Date futureDate = getFutureDate();
          Appointment appointment1 = new
  Appointment("12345", futureDate, "First appointment");
          Appointment appointment2 = new
  Appointment("12345", futureDate, "Second appointment");

          appointmentService.addAppointment(appointment1);

          // Adding second appointment with same ID should throw exception
          assertThrows(IllegalArgumentException.class, ()
  -> {

  appointmentService.addAppointment(appointment2);
          });

          // Verify only one appointment exists
          assertEquals(1,
  appointmentService.getAppointmentCount());
      }

      @Test
      public void testAddNullAppointment() {
          // Test that adding null appointment throws exception
          assertThrows(IllegalArgumentException.class, ()
  -> {
              appointmentService.addAppointment(null);
          });

          assertEquals(0,
  appointmentService.getAppointmentCount());
      }

      @Test
      public void testDeleteAppointment() {
          // Test deleting an existing appointment
          Date futureDate = getFutureDate();
          Appointment appointment = new
  Appointment("12345", futureDate, "Test appointment");

          appointmentService.addAppointment(appointment);
          assertEquals(1,
  appointmentService.getAppointmentCount());

          appointmentService.deleteAppointment("12345");

          // Verify the appointment was deleted
          assertFalse(appointmentService.appointmentExists(
  "12345"));
          assertEquals(0,
  appointmentService.getAppointmentCount());

  assertNull(appointmentService.getAppointment("12345"));
      }

      @Test
      public void testDeleteNonExistentAppointment() {
          // Test that deleting non-existent appointment throws exception
          assertThrows(IllegalArgumentException.class, ()
  -> {

  appointmentService.deleteAppointment("nonexistent");
          });
      }

      @Test
      public void testDeleteWithNullId() {
          // Test that deleting with null ID throws exception
          assertThrows(IllegalArgumentException.class, ()
  -> {
              appointmentService.deleteAppointment(null);
          });
      }

      @Test
      public void testDeleteOneOfMultipleAppointments() {
          // Test deleting one appointment while others remain
          Date futureDate = getFutureDate();
          Appointment appointment1 = new
  Appointment("12345", futureDate, "First appointment");
          Appointment appointment2 = new
  Appointment("67890", futureDate, "Second appointment");

          appointmentService.addAppointment(appointment1);
          appointmentService.addAppointment(appointment2);
          assertEquals(2,
  appointmentService.getAppointmentCount());

          appointmentService.deleteAppointment("12345");

          // Verify only the correct appointment was deleted
          assertFalse(appointmentService.appointmentExists(
  "12345"));
          assertTrue(appointmentService.appointmentExists("67890"));
          assertEquals(1,
  appointmentService.getAppointmentCount());
      }

      @Test
      public void testAppointmentServiceInitialState() {
          // Test that new AppointmentService starts empty
          assertEquals(0,
  appointmentService.getAppointmentCount());
          assertFalse(appointmentService.appointmentExists(
  "anyid"));

  assertNull(appointmentService.getAppointment("anyid"));
      }
  }
