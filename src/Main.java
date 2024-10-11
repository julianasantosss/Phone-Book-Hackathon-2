import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Agenda agendaObj = new Agenda();
        Contact contact;
        int agendaSize;
        String answer;
        System.out.println(" --------------- Agenda ---------------");
        while (true) {
            System.out.println("Do you want to indicate the size of your agenda? (yes/no)");
            answer = scanner.nextLine().trim().toLowerCase();  // Convert the answer to lowercase and remove blank spaces.
            if (answer.equals("yes")) {
                System.out.print("Agenda Size: ");
                agendaSize = scanner.nextInt();
                Agenda size = new Agenda(agendaSize);
                scanner.nextLine();
                break;
            } else if (answer.equals("no")) {
                System.out.println("Your phonebook will have the default size (10 contacts)");
                agendaSize = 10;
                Agenda size = new Agenda(agendaSize);
                break;
            } else {
                System.out.println("That's not an option! Please answer 'yes' or 'no'.");
            }
        }

        int menu;
        do {
            System.out.println("------ 1. Add a contact. -------------");
            System.out.println("------ 2. Look my agenda. --------");
            System.out.println("------ 3. Update a contact. ----------");
            System.out.println("------ 4. Remove a contact. ----------");
            System.out.println("------ 5. Exit. ----------------------");
            System.out.print("Select a valid option: ");
            menu = scanner.nextInt();
            scanner.nextLine();
            switch (menu){
                case 1:
                    System.out.print("Enter the name of the contact: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the last name of the contact: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter the last phone number of the contact: ");
                    String phoneNumber = scanner.nextLine();
                    agendaObj.addContact(name, lastName, phoneNumber);
                    break;
                case 2:
                    agendaObj.listContacts();
                    break;

                default:
                    System.out.println("That's not an option!");
            }
        }while (5 != menu);
    }
}