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

    public List<Contact> getContactsByContainingLetter(char letter) {
        return repository.findByContainingLetter(letter);
    }
    

    public Contact findContactByName(String name) {
        return repository.findByName(name);
    }

    public void updateContactName(String oldName, String newName) {
        Contact contact = repository.findByName(oldName);
        if (contact != null) {
            contact.setName(newName);
            System.out.println("Contact name updated successfully");
        } else {
            System.out.println("Contact not found");
        }
    }
    
}
