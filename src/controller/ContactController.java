package controller;

import entity.Contact;
import java.util.List;
import service.ContactService;

public class ContactController {
    private ContactService service = new ContactService();

    public void addContact(String name, String phone) {
        Contact contact = new Contact(name, phone);
        service.addContact(contact);
    }

    public void viewContacts() {
        List<Contact> contacts = service.getAllContacts();
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public void updateContact(String name, String newPhone) {
        service.updateContact(name, newPhone);
    }

    public void deleteContact(String name) {
        service.deleteContact(name);
    }

    public void viewContactsByLetter(char letter) {
        List<Contact> contacts = service.getContactsByStartingLetter(letter);
        if (contacts.isEmpty()) {
            System.out.println("No contacts found starting with" + letter + ".");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public void findContact(String name) {
        Contact contact = service.findContactByName(name);
        if (contact != null) {
            System.out.println(contact);
        } else {
            System.out.println("Contact not found");
        }
    }
}
