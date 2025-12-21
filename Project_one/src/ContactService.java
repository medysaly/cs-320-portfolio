import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    public boolean addContact(Contact contact) {
        if (contact == null || contact.getContactID() == null) {
            throw new IllegalArgumentException("Contact and contact ID cannot be null");
        }

        if (contacts.containsKey(contact.getContactID())) {
            return false;
        }

        contacts.put(contact.getContactID(), contact);
        return true;
    }

    public boolean deleteContact(String contactID) {
        if (contactID == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }

        return contacts.remove(contactID) != null;
    }

    public boolean updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        if (contactID == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }

        Contact contact = contacts.get(contactID);
        if (contact == null) {
            return false;
        }

        if (firstName != null) {
            contact.setFirstName(firstName);
        }
        if (lastName != null) {
            contact.setLastName(lastName);
        }
        if (phone != null) {
            contact.setPhone(phone);
        }
        if (address != null) {
            contact.setAddress(address);
        }

        return true;
    }

    public Contact getContact(String contactID) {
        if (contactID == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }

        return contacts.get(contactID);
    }

    public Map<String, Contact> getAllContacts() {
        return new HashMap<>(contacts);
    }

    public int getContactCount() {
        return contacts.size();
    }

    public void clearAllContacts() {
        contacts.clear();
    }
}
