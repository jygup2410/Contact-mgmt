package service;

import entity.Contact;
import java.util.List;
import java.util.stream.Collectors;
import repository.ContactRepository;

public class ContactService {
    private ContactRepository repository = new ContactRepository();

    public void addContact(Contact contact) {
        repository.save(contact);
    }

    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    public void updateContact(String name, String newPhone) {
        Contact contact = repository.findByName(name);
        if (contact != null) {
            contact.setPhone(newPhone);
        }
    }

    public void updateContactName(String oldName, String newName) {
        Contact contact = repository.findByName(oldName);
        if (contact != null) {
            contact.setName(newName);
        }
    }

    public void deleteContact(String name) {
        repository.deleteByName(name);
    }

    public List<Contact> searchByNameFragment(String fragment) {
        return repository.findAll().stream()
                .filter(contact -> contact.getName().toLowerCase().contains(fragment.toLowerCase()))
                .collect(Collectors.toList());
    }
}
