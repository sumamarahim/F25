
/** *
 * Date: 12/10/2025
 * Lab Task 1:
 * In recording scores for a golf tournament, we enter the name and score of the player as the player finishes. This information is to be retrieved in each of the following ways:
 * For that we have to design a structure which keeps the information in a way that each player has information of the player next to it and the one behind it as well.
 * Implement the above scenario using an appropriate data structure.
 * Your Application should do the following
 *
 * • Add new Player ( at end of list)
 * • Delete a player ( user enters name of player to be deleted)
 * • Display
 * • whole list (all players with their scores
 * • Display player with lowest scores in the list.
 *
 */
class player {

    player next;
    player prev;
    int score;
    String name;

    public player(int score, String name) {
        this.next = null;
        this.prev = null;
        this.score = score;
        this.name = name;
    }
}

// linked list
class golfTounament {

    player head = null;

    void insertAtEnd(int score, String name) {
        player newNode = new player(score, name);
        player S = head;

        if (head == null) {
            head = newNode;
            return;
        }

        while (S.next != null) {
            S = S.next;
        }

        S.next = newNode;
        newNode.prev = S;

    }

    // delete a player
    void delete(String playerName) {
        player S = head;

        while (S != null) {
            if (S.name == playerName) {
                // case 1: deleting if only one player
                if (S.prev == null) {
                    head = S.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } // case 2: deleting if name occur at last
                else if (S.next == null) {
                    S.prev.next = null;
                } // case 3: deleting if name occur in b/w
                else {
                    S.prev.next = S.next;
                    S.next.prev = S.prev;
                }
                return;
            }
            S = S.next;
        }

        System.out.println("(;- Player not found!");
    }

    // display
    public void displayAll() {
        System.out.print("Player Name" + "\tScore\n");
    if (head == null) {
        System.out.println("List is empty.");
        return;
    }

    player S = head;
    int lowestScore = head.score;

    while (S != null) {
        System.out.println(S.name + "\t\t" + S.score);
        if (S.score < lowestScore) {
            lowestScore = S.score;
        }
        S = S.next;
    }

    System.out.println("Lowest Score: " + lowestScore);
}

}

class Main {

    public static void main(String... args) {
        golfTounament list = new golfTounament();
        list.insertAtEnd(15, "Ali");
        list.insertAtEnd(10, "Basit");
        list.insertAtEnd(45, "Saad");
        list.insertAtEnd(40, "Hamza");
        list.delete("Basit"); // this will not be printed bcz it has been deleted now.
        list.displayAll();

    }
}
