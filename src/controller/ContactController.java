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
            System.out.println("\n--- Contacts List ---");
            System.out.printf("%-20s | %-15s\n", "Name", "Phone");
            System.out.println("-------------------------------");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public void updateContact(String name, String newPhone) {
        service.updateContact(name, newPhone);
    }

    public void updateContactName(String oldName, String newName) {
        service.updateContactName(oldName, newName); // Now added
    }

    public void deleteContact(String name) {
        service.deleteContact(name);
    }

    public void searchByNameFragment(String fragment) {
        List<Contact> contacts = service.searchByNameFragment(fragment);
        if (contacts.isEmpty()) {
            System.out.println("No contacts found with name containing: " + fragment);
        } else {
            System.out.println("\n--- Search Results ---");
            System.out.printf("%-20s | %-15s\n", "Name", "Phone");
            System.out.println("-------------------------------");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public void viewContactsByPhoneDigits(String digits) {
        List<Contact> contacts = service.getContactsByPhoneContains(digits);
        if (contacts.isEmpty()) {
            System.out.println("No contacts found with phone number containing: " + digits);
        } else {
            System.out.println("\n--- Contacts with Phone Number Containing '" + digits + "' ---");
            System.out.printf("%-20s | %-15s\n", "Name", "Phone");
            System.out.println("-------------------------------");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }
}
