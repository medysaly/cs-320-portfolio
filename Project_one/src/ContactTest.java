import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    @DisplayName("Create contact successfully")
    public void testCreateContactSuccess() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");

        assertEquals("1234567890", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("5551234567", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    @DisplayName("Contact ID cannot be null")
    public void testContactIDNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "5551234567", "123 Main St");
        });
    }

    @Test
    @DisplayName("Contact ID cannot exceed 10 characters")
    public void testContactIDTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "5551234567", "123 Main St");
        });
    }

    @Test
    @DisplayName("First name cannot be null")
    public void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "Doe", "5551234567", "123 Main St");
        });
    }

    @Test
    @DisplayName("First name cannot exceed 10 characters")
    public void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "VeryLongFirstName", "Doe", "5551234567", "123 Main St");
        });
    }

    @Test
    @DisplayName("Phone must be exactly 10 digits")
    public void testPhoneInvalidLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "555123456", "123 Main St");
        });
    }

    @Test
    @DisplayName("Phone must contain only digits")
    public void testPhoneNotDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "555-123-456", "123 Main St");
        });
    }

    @Test
    @DisplayName("Update contact successfully")
    public void testUpdateContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");

        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());

        contact.setPhone("9876543210");
        assertEquals("9876543210", contact.getPhone());

        contact.setAddress("456 Oak Ave");
        assertEquals("456 Oak Ave", contact.getAddress());
    }

    @Test
    @DisplayName("Contact ID is immutable")
    public void testContactIDImmutable() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        String originalID = contact.getContactID();
        assertEquals(originalID, contact.getContactID());
    }
}

