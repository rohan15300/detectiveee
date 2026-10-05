/**
 * Student 1: Suspect Management
 * Represents individual suspects and provides methods to manage them.
 */
public class Suspect {
    // Data members
    private int id;
    private String name;
    private String location;
    private String alibi;

    // Constructor using the 'this' keyword
    public Suspect(int id, String name, String location, String alibi) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.alibi = alibi;
    }

    // Getters
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }

    public String getAlibi() {
        return this.alibi;
    }

    // Method to display details of a single suspect
    public void displayDetails() {
        System.out.println("ID       : " + this.id);
        System.out.println("Name     : " + this.name);
        System.out.println("Location : " + this.location);
        System.out.println("Alibi    : " + this.alibi);
        System.out.println("----------------------------------------");
    }

    // Creates the 5 suspects and returns them as an array of objects
    public static Suspect[] initializeSuspects() {
        Suspect[] suspects = new Suspect[5];
        suspects[0] = new Suspect(1, "Alex", "Computer Lab", "Working on a project");
        suspects[1] = new Suspect(2, "Maya", "Library", "Studying");
        suspects[2] = new Suspect(3, "Rahul", "Staff Room", "Meeting a faculty member");
        suspects[3] = new Suspect(4, "Sara", "Canteen", "Having lunch");
        suspects[4] = new Suspect(5, "Arjun", "Department Office", "Collecting documents");
        return suspects;
    }

    // Method to display all suspects using a for-each loop
    public static void displayAllSuspects(Suspect[] suspects) {
        System.out.println("\n========== LIST OF SUSPECTS ==========");
        for (Suspect s : suspects) {
            s.displayDetails();
        }
    }
}