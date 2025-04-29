import controller.ContactController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactController controller = new ContactController();

        String choice;
        do {
            System.out.println("\n--- Contact Management System ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Update Contact Phone no.");
            System.out.println("4. Update Contact Name");
            System.out.println("5. Delete Contact");
            System.out.println("6. View Contacts by Starting Letter");
            System.out.println("7. Find Contact by Name");
            System.out.println("8. Exit");
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
                        if (phone.length() != 10 || !phone.matches("\\d{10}")) {
                            System.out.println("Invalid phone number. Please enter exactly 10 digits.");
                        }
                    } while (phone.length() != 10 || !phone.matches("\\d{10}"));

                    controller.addContact(name, phone);
                    break;

                case "view":
                    controller.viewContacts();
                    break;

                case "update phone":
                    System.out.print("Enter the name of the contact to update: ");
                    String updateName = scanner.nextLine();

                    String newPhone;
                    do {
                        System.out.print("Enter new 10-digit phone number: ");
                        newPhone = scanner.nextLine();
                        if (newPhone.length() != 10 || !newPhone.matches("\\d{10}")) {
                            System.out.println("Invalid phone number. Please enter exactly 10 digits.");
                        }
                    } while (newPhone.length() != 10 || !newPhone.matches("\\d{10}"));

                    controller.updateContact(updateName, newPhone);
                    break;

                case "update name":
                    System.out.print("Enter the name of the contact to rename: ");
                    String oldName = scanner.nextLine();
                    System.out.print("Enter the new name: ");
                    String newName = scanner.nextLine();
                    controller.updateContactName(oldName, newName);
                    break;
                case "delete":
                    System.out.print("Enter the name of the contact to delete: ");
                    String deleteName = scanner.nextLine();
                    controller.deleteContact(deleteName);
                    break;

                case "search":
                    System.out.print("Enter the starting letter: ");
                    char letter = scanner.nextLine().charAt(0);
                    controller.viewContactsByLetter(letter);
                    break;

                case "find":
                    System.out.print("Enter the name of the contact to find: ");
                    String findName = scanner.nextLine();
                    controller.findContact(findName);
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