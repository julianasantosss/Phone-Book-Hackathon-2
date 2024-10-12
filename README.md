# Phone-Book-Hackathon-2
This project is a simple phonebook management system that allows users to store, organize, and manage contacts. A contact is defined by a first name, last name, and phone number. The system supports adding, searching, updating, and deleting contacts with key validations to avoid duplicates and empty fields.

## Key Features

- **Add Contact:** Adds a new contact if the name and last name are not empty, and the contact doesn't already exist. Shows a message if the phonebook is full.
  
- **Check for Duplicate Contact:** Verifies if a contact with the same name and last name already exists.

- **List Contacts:** Displays all contacts in alphabetical order by first name and last name in the format:

- **Search Contact:** Searches for a contact by first name and last name, and displays their phone number.

- **Delete Contact:** Removes a contact from the phonebook, showing a message if the deletion is successful or if the contact doesn't exist.

- **Update Phone Number:** Modifies the phone number of an existing contact.

- **Check if Full:** Indicates if the phonebook is full and cannot accept new contacts.

- **Show Free Spaces:** Displays how many more contacts can be added.

## Agenda Configuration
The phonebook can be created with:
- A custom maximum size.
- A default size of 10 contacts.

## Requirements
- Java 8 or later.

## How to Run
1. Clone the repository.
2. Compile and run `Main.java`.
3. Use the console menu to manage the phonebook.


