import java.util.HashMap;
import java.util.Map;

public class Agenda {

    Map<String, Contact> contactsList;
    private String key;
    private int agendaSize;

    public Agenda() {
        this.contactsList = new HashMap<>();
        this.agendaSize = 10;
    }
    public Agenda(int agendaSize) {
        this.contactsList = new HashMap<>();
        this.agendaSize = agendaSize;
    }

    public void freeSpaces(){
        int spacesLeft =agendaSize - contactsList.size();
        System.out.println("You can add " + spacesLeft + " more contact(s) to your agenda.");
        System.out.println("---------------------------------------------\n");
    }

    public boolean agendaIsFull() {
        return contactsList.size() >= agendaSize;
    }

    public void addContact(String name, String lastName, String phoneNumber){
        if (agendaIsFull()) {
            System.out.println("---------------------------------------------");
            System.out.println("   The agenda is full. No space available.");
            System.out.println("---------------------------------------------");
            return;
        }
        // Remove blanks and convert to capitalize
        String cleanName = capitalize(name.trim());
        String cleanLastName = capitalize(lastName.trim());
        key = (cleanName + " " + cleanLastName);
        if (existsContact(cleanName, cleanLastName)) {
            System.out.println("---------------------------------------------");
            System.out.println("        The contact already exists!");
            System.out.println("---------------------------------------------");
        } else {
            if (cleanName.isEmpty() || cleanLastName.isEmpty()) {
                System.out.println("---------------------------------------------");
                System.out.println("     Name and Last Name cannot be empty!");
                System.out.println("---------------------------------------------\n");
            } else {
                Contact newContact = new Contact(cleanName, cleanLastName, phoneNumber);
                contactsList.put(key, newContact);
                System.out.println("---------------------------------------------");
                System.out.println("         Contact added successfully!");
                System.out.println(newContact.toString());
            }
        }
    }
    public boolean existsContact(String cleanName, String cleanLastName){
        //Verify if there is a key equal to name and LastName
        key = capitalize(cleanName.trim()) + " " + capitalize(cleanLastName.trim());
        return contactsList.containsKey(key);
    }

    public static String capitalize(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return inputString;
        }
        // Converts the first letter to uppercase and the rest to lowercase
        return inputString.substring(0, 1).toUpperCase() + inputString.substring(1).toLowerCase();
    }

    public void listContacts(){
        if (contactsList.isEmpty()) {
            System.out.println("           No contacts found.");
            System.out.println("---------------------------------------------\n");
        } else{
            int i = 1;
            for (String key : contactsList.keySet()) {
                Contact contact = contactsList.get(key);
                System.out.println("          " + i + ". " + key + " - " + contact.getPhoneNumber());
                i++;
            }
            System.out.println("---------------------------------------------\n");
        }
    }

    public void searchContact(String name, String lastName) {
        // Generate the key to search for the contact
        key = capitalize(name.trim()) + " " + capitalize(lastName.trim());

        //Verify if there is a key equal to name and LastName
        if (contactsList.containsKey(key)) {
            Contact foundContact = contactsList.get(key);
            System.out.println(foundContact.toString());
        } else {
            System.out.println("---------------------------------------------");
            System.out.println("       That contact does not exist!");
            System.out.println("---------------------------------------------\n");
        }
    }

    public void deleteContact(String name, String lastName) {
        // Generate the key to search for the contact
        key = capitalize(name.trim()) + " " + capitalize(lastName.trim());

        //Verify if there is a key equal to name and LastName
        if (contactsList.containsKey(key)) {
            contactsList.remove(key);
            System.out.println("---------------------------------------------");
            System.out.println("        Contact removed successfully!");
            System.out.println("---------------------------------------------\n");
        } else {
            System.out.println("---------------------------------------------");
            System.out.println("The contact does not exist, cannot remove.");
            System.out.println("---------------------------------------------\n");
        }
    }

    public void updateContact(String name, String lastName, String nuevoTelefono) {
        // Generate the key to search for the contact
        key = capitalize(name.trim()) + " " + capitalize(lastName.trim());
        //Verify if there is a key equal to name and LastName
        if (contactsList.containsKey(key)) {
            Contact contact = contactsList.get(key);
            contact.setPhoneNumber(nuevoTelefono);
            System.out.println("---------------------------------------------");
            System.out.println("    Phone number updated for " + key);
            System.out.println("---------------------------------------------\n");
        } else {

            System.out.println("The contact does not exist, it is impossible\n to update the phone number.");
            System.out.println("---------------------------------------------");
        }
    }

}
