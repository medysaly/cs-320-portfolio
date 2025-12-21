import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService service;
    private Contact testContact;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
        testContact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
    }

    @Test
    @DisplayName("Add contact successfully")
    public void testAddContactSuccess() {
        assertTrue(service.addContact(testContact));
        assertEquals(testContact, service.getContact("1234567890"));
        assertEquals(1, service.getContactCount());
    }

    @Test
    @DisplayName("Cannot add contact with duplicate ID")
    public void testAddContactDuplicateID() {
        service.addContact(testContact);

        Contact duplicateContact = new Contact(
            "1234567890",
            "Jane",
            "Smith",
            "9876543210",
            "456 Oak Ave"
        );

        assertFalse(service.addContact(duplicateContact));
        assertEquals(1, service.getContactCount());
        assertEquals("John", service.getContact("1234567890").getFirstName());
    }

    @Test
    @DisplayName("Cannot add null contact")
    public void testAddNullContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(null);
        });
    }

    @Test
    @DisplayName("Delete contact successfully")
    public void testDeleteContactSuccess() {
        service.addContact(testContact);
        assertEquals(1, service.getContactCount());

        assertTrue(service.deleteContact("1234567890"));
        assertNull(service.getContact("1234567890"));
        assertEquals(0, service.getContactCount());
    }

    @Test
    @DisplayName("Delete nonexistent contact returns false")
    public void testDeleteNonexistentContact() {
        assertFalse(service.deleteContact("nonexistent"));
        assertEquals(0, service.getContactCount());
    }

    @Test
    @DisplayName("Update contact successfully")
    public void testUpdateContactSuccess() {
        service.addContact(testContact);

        assertTrue(service.updateContact(
            "1234567890",
            "Jane",
            "Smith",
            "9876543210",
            "456 Oak Ave"
        ));

        Contact updatedContact = service.getContact("1234567890");

        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("9876543210", updatedContact.getPhone());
        assertEquals("456 Oak Ave", updatedContact.getAddress());
    }

    @Test
    @DisplayName("Update nonexistent contact returns false")
    public void testUpdateNonexistentContact() {
        assertFalse(service.updateContact("nonexistent", "Jane", null, null, null));
    }

    @Test
    @DisplayName("Get contact successfully")
    public void testGetContact() {
        service.addContact(testContact);
        Contact retrieved = service.getContact("1234567890");
        assertEquals(testContact, retrieved);
    }

    @Test
    @DisplayName("Get nonexistent contact returns null")
    public void testGetNonexistentContact() {
        assertNull(service.getContact("nonexistent"));
    }

    @Test
    @DisplayName("Clear all contacts")
    public void testClearAllContacts() {
        service.addContact(testContact);

        Contact contact2 = new Contact(
            "0987654321",
            "Jane",
            "Smith",
            "9876543210",
            "456 Oak Ave"
        );

        service.addContact(contact2);

        assertEquals(2, service.getContactCount());
        service.clearAllContacts();
        assertEquals(0, service.getContactCount());
        assertTrue(service.getAllContacts().isEmpty());
    }
}

