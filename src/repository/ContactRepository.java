package repository;

import entity.Contact;
import java.util.ArrayList;
import java.util.List;

public class ContactRepository {
    private List<Contact> contacts = new ArrayList<>();

    public ContactRepository() {
        contacts.add(new Contact("Ram", "9876543210"));
        contacts.add(new Contact("Raju", "9123456780"));
        contacts.add(new Contact("Shyam", "9988776655"));
        contacts.add(new Contact("Mohan", "9012345678"));
        contacts.add(new Contact("Sohan", "8899776655"));
        contacts.add(new Contact("Radha", "7777888899"));
        contacts.add(new Contact("Meena", "8111222233"));
        contacts.add(new Contact("Gopal", "9666554433"));
        contacts.add(new Contact("Ravi", "9000111222"));
        contacts.add(new Contact("Pooja", "9555666777"));
    }

    public void save(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> findAll() {
        return contacts;
    }

    public boolean deleteByName(String name) {
        return contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
    }

    public Contact findByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }
}
