/**
 * Student 3: Investigation and Accusation
 * Handles suspect searches, accusations, and win/loss resolution.
 */
public class Investigation {
    private Suspect[] suspects;
    private int attemptsLeft;
    private boolean caseSolved;

    // Actual culprit is Arjun (Suspect ID 5), who was present in the Department Office
    private static final int CULPRIT_ID = 5;

    public Investigation(Suspect[] suspects) {
        this.suspects = suspects;
        this.attemptsLeft = 3;
        this.caseSolved = false;
    }

    // Method to search for a suspect using suspect ID
    public void searchSuspect(int suspectId) {
        System.out.println("\nInvestigating Suspect ID: " + suspectId);
        boolean found = false;

        for (int i = 0; i < suspects.length; i++) {
            if (suspects[i].getId() == suspectId) {
                System.out.println("Suspect located:");
                suspects[i].displayDetails();
                found = true;
                break; // Demonstrates break statement
            }
        }

        if (!found) {
            System.out.println("No suspect found with ID " + suspectId + ".");
        }
    }

    // Method handling the accusation logic
    public boolean accuseSuspect(int suspectId) {
        System.out.println("\nAccusing Suspect ID: " + suspectId + "...");

        if (this.caseSolved) {
            System.out.println("The case has already been solved!");
            return true;
        }

        if (this.attemptsLeft <= 0) {
            System.out.println("No accusation attempts remaining.");
            return false;
        }

        this.attemptsLeft--;

        if (suspectId == CULPRIT_ID) {
            this.caseSolved = true;
            System.out.println("========================================");
            System.out.println("CASE SOLVED!");
            System.out.println("You identified the culprit.");
            System.out.println("The missing question paper has been recovered.");
            System.out.println("========================================");
            return true;
        } else {
            System.out.println("INCORRECT ACCUSATION! Suspect " + suspectId + " is not the culprit.");
            System.out.println("Attempts remaining: " + this.attemptsLeft);

            if (this.attemptsLeft == 0) {
                System.out.println("========================================");
                System.out.println("INVESTIGATION FAILED!");
                System.out.println("You have used all three attempts.");
                System.out.println("The culprit escaped.");
                System.out.println("========================================");
            }
            return false;
        }
    }

    public boolean isCaseSolved() {
        return this.caseSolved;
    }

    public int getAttemptsLeft() {
        return this.attemptsLeft;
    }
}