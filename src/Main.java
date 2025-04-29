import controller.ContactController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactController controller = new ContactController();
        String choice;

        do {
            System.out.println("\n--- Contact Management System ---");
            System.out.println("Add Contact -> add");
            System.out.println("View All Contacts -> view");
            System.out.println("Update Contact Phone no. -> update ph");
            System.out.println("Update Contact Name -> update name");
            System.out.println("Delete Contact -> delete");
            System.out.println("Search Contacts -> search");
            System.out.println("Exit -> exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "add":
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    String phone;
                    do {
                        System.out.print("Enter 10-digit phone number: ");
                        phone = scanner.nextLine();
                        if (!phone.matches("\\d{10}")) {
                            System.out.println("Invalid phone number. Please enter exactly 10 digits.");
                        }
                    } while (!phone.matches("\\d{10}"));

                    controller.addContact(name, phone);
                    break;

                case "view":
                    controller.viewContacts();
                    break;

                case "update ph":
                    System.out.print("Enter the name of the contact to update: ");
                    String updateName = scanner.nextLine();
                    String newPhone;
                    do {
                        System.out.print("Enter new 10-digit phone number: ");
                        newPhone = scanner.nextLine();
                        if (!newPhone.matches("\\d{10}")) {
                            System.out.println("Invalid phone number. Please enter exactly 10 digits.");
                        }
                    } while (!newPhone.matches("\\d{10}"));
                    controller.updateContact(updateName, newPhone);
                    break;

                case "update name":
                    System.out.print("Enter current name: ");
                    String oldName = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    controller.updateContactName(oldName, newName);
                    break;

                case "delete":
                    System.out.print("Enter the name of the contact to delete: ");
                    String deleteName = scanner.nextLine();
                    controller.deleteContact(deleteName);
                    break;

                case "search":
                    System.out.print("Enter name or part of name to search: ");
                    String fragment = scanner.nextLine();
                    controller.searchByNameFragment(fragment);
                    break;

                case "exit":
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("exit"));

        scanner.close();
    }
}
