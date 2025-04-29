package controller;

import entity.Contact;
import java.util.List;
import service.ContactService;

public class ContactController {
    private ContactService service = new ContactService();

    public void addContact(String name, String phone) {
        service.addContact(new Contact(name, phone));
    }

    public void viewContacts() {
        List<Contact> contacts = service.getAllContacts();
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            contacts.forEach(System.out::println);
        }
    }

    public void updateContact(String name, String newPhone) {
        service.updateContact(name, newPhone);
    }

    public void deleteContact(String name) {
        service.deleteContact(name);
    }

    public void updateContactName(String oldName, String newName) {
        service.updateContactName(oldName, newName);
    }

    public void searchByNameFragment(String fragment) {
        List<Contact> results = service.searchByNameFragment(fragment);
        if (results.isEmpty()) {
            System.out.println("No contacts found containing: " + fragment);
        } else {
            results.forEach(System.out::println);
        }
    }
}
