package service;

import entity.Contact;
import java.util.List;
import repository.ContactRepository;

public class ContactService {
    private ContactRepository repository = new ContactRepository();

    public void addContact(Contact contact) {
        repository.save(contact);
        System.out.println("Contact added successfully");
    }

    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    public void deleteContact(String name) {
        boolean removed = repository.deleteByName(name);
        if (removed) {
            System.out.println("Contact deleted successfully");
        } else {
            System.out.println("Contact not found");
        }
    }

    public void updateContact(String name, String newPhone) {
        Contact contact = repository.findByName(name);
        if (contact != null) {
            contact.setPhoneNumber(newPhone);
            System.out.println("Contact updated successfully");
        } else {
            System.out.println("Contact not found");
        }
    }

    public List<Contact> getContactsByStartingLetter(char letter) {
        return repository.findByStartingLetter(letter);
    }

    public Contact findContactByName(String name) {
        return repository.findByName(name);
    }
}
