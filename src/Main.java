import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Agenda agendaObj = new Agenda();
        Contact contact;
        int agendaSize;
        String answer;
        System.out.println("---------------- Agenda ---------------------");
        while (true) {
            System.out.print("Do you want to indicate the size of your \nagenda? (yes/no) --> ");
            answer = scanner.nextLine().trim().toLowerCase();  // Convert the answer to lowercase and remove blank spaces.
            if (answer.equals("yes")) {
                System.out.println("---------------------------------------------");
                System.out.print("Agenda Size: ");
                agendaSize = scanner.nextInt();
                System.out.println("---------------------------------------------");

                agendaObj = new Agenda(agendaSize);
                scanner.nextLine();
                break;
            } else if (answer.equals("no")) {
                System.out.println("---------------------------------------------");
                System.out.println("Warning --> Your phonebook will have \nthe default size (10 contacts)");
                System.out.println("---------------------------------------------");
                break;
            } else {
                System.out.println("---------------------------------------------");
                System.out.println("That's not an option! Pls answer 'yes' or 'no'");
                System.out.println("---------------------------------------------");

            }
        }
        int menu;
        do {
            System.out.println("------ 1. Add a contact. --------------------");
            System.out.println("------ 2. Look a contact. -------------------");
            System.out.println("------ 3. Look my agenda. -------------------");
            System.out.println("------ 4. Update a phone number. ------------");
            System.out.println("------ 5. Remove a contact. -----------------");
            System.out.println("------ 6. Check my agenda availability. -----");
            System.out.println("------ 7. Exit. -----------------------------");
            System.out.println("---------------------------------------------");
            System.out.print("       Select a valid option: ");
            menu = scanner.nextInt();
            System.out.println("---------------------------------------------");
            scanner.nextLine();
            switch (menu){
                case 1:
                    System.out.println("\n---------------------------------------------");
                    System.out.println("              Add a Contact");
                    System.out.println("---------------------------------------------");
                    System.out.print("Enter the name of the contact: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the last name of the contact: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter the last phone number of the contact: ");
                    String phoneNumber = scanner.nextLine();
                    agendaObj.addContact(name, lastName, phoneNumber);
                    break;
                case 2:
                    System.out.println("\n---------------------------------------------");
                    System.out.println("           Look for a Contact");
                    System.out.println("---------------------------------------------");
                    System.out.print("Enter the name of the contact: ");
                    String nameS = scanner.nextLine();
                    System.out.print("Enter the last name of the contact: ");
                    String lastNameS = scanner.nextLine();
                    agendaObj.searchContact(nameS, lastNameS);
                    break;
                case 3:
                    System.out.println("\n---------------------------------------------");
                    System.out.println("                 My Agenda:");
                    System.out.println("---------------------------------------------");
                    agendaObj.listContacts();
                    break;
                case 4:
                    System.out.println("\n---------------------------------------------");
                    System.out.println("         Update a Phone Number");
                    System.out.println("---------------------------------------------");
                    System.out.print("Enter the name of the contact: ");
                    String nameU = scanner.nextLine();
                    System.out.print("Enter the last name of the contact: ");
                    String lastNameU = scanner.nextLine();
                    System.out.print("Enter the new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    agendaObj.updateContact(nameU, lastNameU, newPhoneNumber);
                    break;
                case 5:
                    System.out.println("\n---------------------------------------------");
                    System.out.println("              Delete a Contact");
                    System.out.println("---------------------------------------------");
                    System.out.print("Enter the name of the contact: ");
                    String nameD = scanner.nextLine();
                    System.out.print("Enter the last name of the contact: ");
                    String lastNameD = scanner.nextLine();
                    agendaObj.deleteContact(nameD, lastNameD);
                    break;
                case 6:
                    agendaObj.freeSpaces();
                    break;
                case 7:
                    System.out.println("---------------------------------------------");
                    System.out.println("       Thanks for using our Agenda, bye!");
                    System.out.println("---------------------------------------------");
                    break;
                default:
                    System.out.println("---------------------------------------------");
                    System.out.println("             That's not an option!");
                    System.out.println("---------------------------------------------");
            }
        }while (7 != menu);
    }
}