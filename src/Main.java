import controller.ContactController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactController controller = new ContactController();

        int choice;
        do {
            System.out.println("\n--- Contact Management System ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. View Contacts by Starting Letter");
            System.out.println("6. Find Contact by Name");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    controller.addContact(name, phone);
                    break;

                case 2:
                    controller.viewContacts();
                    break;

                case 3:
                    System.out.print("Enter the name of the contact to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhone = scanner.nextLine();
                    controller.updateContact(updateName, newPhone);
                    break;

                case 4:
                    System.out.print("Enter the name of the contact to delete: ");
                    String deleteName = scanner.nextLine();
                    controller.deleteContact(deleteName);
                    break;

                case 5:
                    System.out.print("Enter the starting letter: ");
                    char letter = scanner.nextLine().charAt(0);
                    controller.viewContactsByLetter(letter);
                    break;

                case 6:
                    System.out.print("Enter the name of the contact to find: ");
                    String findName = scanner.nextLine();
                    controller.findContact(findName);
                    break;

                case 7:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
