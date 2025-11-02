
/**
 * Lab Task 3:
You are required to implement a basic social media portal where a user can create his/her profile
You can provide user the options to create a new profile, update profile and delete profile as well.

Create a class Profile having necessary information of user ( ID, Name, gender, age, email, interest, Date of birth) provide appropriate methods.
Next create a class Portal which uses node of Profile Class to handle profiles. Next provide methods to 
⦁	InsertProfile (ID, Name, gender, age, email, interest, Date of birth)// adds new profile to the list.
⦁	UpdateProfile (int id) which helps user to update his/her profile information)
⦁	DeleteProfile(string name)// delete a particular profile form the list
⦁	searchProfile(string name)
⦁	displayProfiles ()// display all values.
In main create a menu to show the following options to the user
⦁	Add new Profile
⦁	Update Profile ( which helps user to update his/her profile information)
⦁	Delete a Profile
⦁	Search Profile
⦁	Display All
⦁	Exit.
The program runs until user wants to exit.

 */

/**
 * Name: Sumama Rahim
 * Reg# F24BSCS039
 * Date: 11/02/2025
 * Course: Data Structures
 * Instructor: Ms. Engr. Afifa Zafar
 */

import java.util.Scanner;

public class Portal {

    // Profile Node class
    class Profile {
        int id, age;
        String name, gender, email, interest, dob;
        Profile next;

        Profile(int id, String name, String gender, int age, String email, String interest, String dob) {
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.age = age;
            this.email = email;
            this.interest = interest;
            this.dob = dob;
            this.next = null;
        }
    }

    Profile head = null; // starting node

    // Function to add new profile at the end
    void insertProfile(int id, String name, String gender, int age, String email, String interest, String dob) {
        Profile newNode = new Profile(id, name, gender, age, email, interest, dob);
        if (head == null) {
            head = newNode;
        } else {
            Profile temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Profile Added!");
    }

    // Function to update a profile by ID
    void updateProfile(int id) {
        Scanner takeInput = new Scanner(System.in);
        Profile temp = head;
        while (temp != null) {
            if (temp.id == id) {
                System.out.println("Enter new Name: ");
                temp.name = takeInput.nextLine();
                System.out.println("Enter new Gender: ");
                temp.gender = takeInput.nextLine();
                System.out.println("Enter new Age: ");
                temp.age = takeInput.nextInt();
                takeInput.nextLine(); // clear buffer
                System.out.println("Enter new Email: ");
                temp.email = takeInput.nextLine();
                System.out.println("Enter new Interest: ");
                temp.interest = takeInput.nextLine();
                System.out.println("Enter new DOB: ");
                temp.dob = takeInput.nextLine();
                System.out.println("Profile Updated Successfully!");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Profile not found!");
    }

    // delete a profile by name
    void deleteProfile(String name) {
        if (head == null) {
            System.out.println("No profiles to delete!");
            return;
        }

        if (head.name.equalsIgnoreCase(name)) {
            head = head.next;
            System.out.println("Profile Deleted!");
            return;
        }

        Profile temp = head;
        while (temp.next != null) {
            if (temp.next.name.equalsIgnoreCase(name)) {
                temp.next = temp.next.next;
                System.out.println("Profile Deleted!");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Profile not found!");
    }

    // search profile by name
    void searchProfile(String name) {
        Profile temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("\nProfile Found:");
                System.out.println("ID: " + temp.id);
                System.out.println("Name: " + temp.name);
                System.out.println("Gender: " + temp.gender);
                System.out.println("Age: " + temp.age);
                System.out.println("Email: " + temp.email);
                System.out.println("Interest: " + temp.interest);
                System.out.println("DOB: " + temp.dob);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Profile not found!");
    }

    // Function to display all profiles
    void display() {
        if (head == null) {
            System.out.println("No profiles!");
            return;
        }

        Profile temp = head;
        int count = 1;
        while (temp != null) {
            System.out.println("\nProfile #" + count);
            System.out.println("ID: " + temp.id);
            System.out.println("Name: " + temp.name);
            System.out.println("Gender: " + temp.gender);
            System.out.println("Age: " + temp.age);
            System.out.println("Email: " + temp.email);
            System.out.println("Interest: " + temp.interest);
            System.out.println("DOB: " + temp.dob);
            temp = temp.next;
            count++;
        }
    }

    // MAIN METHOD
    public static void main(String[] args) {
        Scanner takeInput = new Scanner(System.in);
        Portal portal = new Portal();

        // Simple menu using for loop
        for (;;) {
            System.out.println("\nSocial Media Portal Menu");
            System.out.println("1. Add Profile");
            System.out.println("2. Update Profile");
            System.out.println("3. Delete Profile");
            System.out.println("4. Search Profile");
            System.out.println("5. Display All Profiles");
            System.out.println("0. Exit");
            System.out.print("Enter your option: ");
            int choice = takeInput.nextInt();
            takeInput.nextLine(); // clear buffer

            if (choice == 0) {
                System.out.println("Program Ended!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = takeInput.nextInt();
                    takeInput.nextLine();
                    System.out.print("Enter Name: ");
                    String name = takeInput.nextLine();
                    System.out.print("Enter Gender: ");
                    String gender = takeInput.nextLine();
                    System.out.print("Enter Age: ");
                    int age = takeInput.nextInt();
                    takeInput.nextLine();
                    System.out.print("Enter Email: ");
                    String email = takeInput.nextLine();
                    System.out.print("Enter Interest: ");
                    String interest = takeInput.nextLine();
                    System.out.print("Enter Date of Birth: ");
                    String dob = takeInput.nextLine();
                    portal.insertProfile(id, name, gender, age, email, interest, dob);
                    break;

                case 2:
                    System.out.print("Enter ID to update: ");
                    int uid = takeInput.nextInt();
                    takeInput.nextLine();
                    portal.updateProfile(uid);
                    break;

                case 3:
                    System.out.print("Enter Name to delete: ");
                    String dname = takeInput.nextLine();
                    portal.deleteProfile(dname);
                    break;

                case 4:
                    System.out.print("Enter Name to search: ");
                    String sname = takeInput.nextLine();
                    portal.searchProfile(sname);
                    break;

                case 5:
                    portal.display();
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
