import java.util.HashMap;
import java.util.Map;

public class Agenda {

    Map<String, Contact> contactsList;
    private String key;
    private int agendaSize;

    public Agenda() {
        this.contactsList = new HashMap<>();
    }
    public Agenda(int agendaSize) {
        this.agendaSize = agendaSize;
    }

    public boolean agendaIsFull() {
        return contactsList.size() >= agendaSize;
    }

    public void addContact(String name, String lastName, String phoneNumber){
        if (agendaIsFull()) {
            System.out.println("The agenda is full. No space available for new contacts.");
            return;
        }
        // Remove blanks and convert to capitalize
        String cleanName = capitalize(name.trim());
        String cleanLastName = capitalize(lastName.trim());
        key = (cleanName + " " + cleanLastName);
        if (existsContact(cleanName, cleanLastName)) {
            System.out.println("The contact already exists!");
        } else {
            if (cleanName.isEmpty() || cleanLastName.isEmpty()) {
                System.out.println("Name and Last Name cannot be empty!");
            } else {
                Contact newContact = new Contact(cleanName, cleanLastName, phoneNumber);
                contactsList.put(key, newContact);
                System.out.println("Contact added successfully!");
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
            System.out.println("No contacts found.");
        } else{
            int i = 1;
            for (String key : contactsList.keySet()) {
                Contact contact = contactsList.get(key);
                System.out.println(i + ". " + key + " - " + contact.getPhoneNumber());
                i++;
            }
        }
    }

    public void freeSpaces(){

    }

}
