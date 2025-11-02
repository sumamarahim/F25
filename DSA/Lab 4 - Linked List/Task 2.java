/**
 * Lab 4
 * Lab Task 2:
 * Write a class named Mobile that holds data about a mobile in a retail store.
 * The class should have the following member variables:
 * • Name/brand. A string that holds name of the brand of phone.
 * • unitsOnHand. An int that holds the number of units currently in inventory.
 * • price. A double that holds the retail price.
 * Write a constructor that accepts arguments for each member variable,
 * appropriate functions that store values in these member variables, and
 * accessor functions that return the values in these member variables.
 * Once you have written the class,
 * Write another class Store (link list) having Mobile as a node then provide
 * function to insert new mobile in list and to Delete a mobile and to display
 * all mobiles.
 * Write a main program that shows all the functionality.
 * Note: you have to implement all scenarios (insert and delete at start, end,
 * in between).
 */

/**
 * Name: Sumama Rahim
 * Reg# F24BSCS039
 * Date: 11/02/2025
 * Course: Data Structures
 * Instructor: Ms. Engr. Afifa Zafar
 */

public class Store {
    class Mobile {
        String brand;
        int unitsOnHand;
        double price;
        Mobile next;

        public Mobile(String brand, int units, double price) {
            this.brand = brand;
            this.unitsOnHand = units;
            this.price = price;
            this.next = null;
        }
    }

    // represent the head and tail
    public Mobile head = null;
    public Mobile tail = null;

    // addMobile() will add a new Mobile to the list
    public void addMobile(String brand, int units, double price) {
        // creating a Mobile
        Mobile newMobile = new Mobile(brand, units, price);
        // checks for the existance of Mobile
        if (head == null) {
            head = newMobile;
            tail = newMobile;
        } else {
            tail.next = newMobile;
            tail = newMobile;
        }
    }

    // insertions
    // 1. insert at beginning
    void insertAtStart(String brand, int units, double price) {
        Mobile newMobile = new Mobile(brand, units, price);
        if (head == null) // checks if Mobile is empty
        {
            head = newMobile;
        } else // insert Mobile at start
        {
            newMobile.next = head;
            head = newMobile;
        }
    }

    // 2.0 insert at end - without tail
    void insertAtEnd(String brand, int units, double price) {
        Mobile newMobile = new Mobile(brand, units, price);
        Mobile S = head; // it will copy the head and we'll use it and keep the head as point first
        // Mobile
        while (S.next != null) {
            S = S.next;
        }
        // Shifting
        S.next = newMobile;
        newMobile.next = null;
    }

    // 2.1 insert at end - with tail
    void insertAtEndWithTail(String brand, int units, double price) {
        Mobile newMobile = new Mobile(brand, units, price);
        Mobile tail = head; // it will copy the head and we'll use it and keep the head as point first
        // Mobile
        while (tail.next != null) {
            tail = tail.next;
        }
        // Shifting
        tail.next = newMobile;
        newMobile.next = null;
    }

    // // 3. insert in between (at specific location/position etc.)

    void insertInBetween(String brand, int units, double price, String addAfter) {
        Mobile newMobile = new Mobile(brand, units, price);
        Mobile S = head;
        while (S != null) {
            if (S.brand == addAfter) {
                // Shifting
                newMobile.next = S.next;
                S.next = newMobile;
            }
            S = S.next;
        }
    }

    // Deletion scenarios
    // Scenario 1: Deletion at start

    void deletionAtStart() {
        // to check if linked list is empty
        if (head == null) {
            System.out.println("LL is empty!");
        } else {
            head = head.next;
        }
    }

    // Scenario 2: Deletion at end
    void deletionAtEnd() {
        Mobile S = head;
        while (S.next.next != null) {
            S = S.next;
        }
        S.next = null;
    }

    // Scenario 3: Deletion in between
    void deletionInBetween(String val) {
        Mobile newMobile = new Mobile(val, 10, 30.00);
        Mobile S = head;
        while (S.next != null) {
            if (S.next.brand == val) {
                S.next = S.next.next;
            }
            S = S.next;
        }
    }

    // displaying Mobiles
    public void display() {
        Mobile S = head;
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        System.out.println("Mobiles of Singly Linked List: ");
        while (S != null) {
            System.out.println("Model: " + S.brand + ", Units: "
                    + S.unitsOnHand + ", Rs. "
                    + S.price);
            S = S.next;
        }
    }

}

class Main {
    public static void main(String... args) {
        Store sList = new Store();
        // add Mobiles to the list

        // insertion
        System.out.println("\nInitially Displaying the linked list!");
        sList.display(); // initialy it should display nothing, cz we don't have anything in list
        System.out.println("\nInserting at start");
        sList.insertAtStart("Note 21", 100, 190.00);
        sList.insertAtStart("S 20", 100, 170.00);
        sList.insertAtStart("S 22", 100, 190.00);
        sList.insertAtStart("S 25", 100, 230.00);
        sList.display();
        System.out.print("\nInserting at end\n");
        sList.insertAtEnd("S 8", 100, 90.00);
        sList.insertAtEnd("S 10", 100, 120.00);
        sList.insertAtEnd("S 9", 100, 110.00);
        sList.display();
        System.out.println("Insertion in between");
        sList.insertInBetween("Alpha 1", 10, 30.00, "S 22");
        sList.display();

        // deletion
        System.out.println("\nDeleting from start");
        sList.deletionAtStart();
        sList.deletionAtStart();
        sList.display();
        System.out.println("\nDeleting from End");
        sList.deletionAtEnd();
        sList.display();
        System.out.println("\nDeletion in between");
        sList.deletionInBetween("Alpha 1");
        sList.display();

    }
}
