/**
 * Student 2: Clue Management
 * Manages the available investigation clues and tracks collected status.
 */
public class ClueManager {
    // Array containing the five clues
    private String[] clues;

    // Mechanism to track whether a clue has been collected
    private boolean[] collected;

    // Constructor initializing the 5 clues
    public ClueManager() {
        this.clues = new String[] {
            "The office door was opened at 2:15 PM.",
            "CCTV shows someone entering the office.",
            "A torn piece of paper was found near the printer.",
            "A suspect's ID card was found inside the office.",
            "The printer was used shortly before the question paper disappeared."
        };
        this.collected = new boolean[this.clues.length];
    }

    // Method to display available clues
    public void displayAvailableClues() {
        System.out.println("\n========== AVAILABLE CLUES ==========");
        for (int i = 0; i < clues.length; i++) {
            if (collected[i]) {
                System.out.println((i + 1) + ". [COLLECTED] " + clues[i]);
                continue; // Demonstrates the continue statement
            }
            System.out.println((i + 1) + ". [UNCOLLECTED] Clue #" + (i + 1));
        }
    }

    // Method to collect a clue using a predefined clue number (1-based index)
    public boolean collectClue(int clueNumber) {
        if (clueNumber < 1 || clueNumber > clues.length) {
            System.out.println("Invalid clue number: " + clueNumber + ". Please choose between 1 and 5.");
            return false;
        }

        int index = clueNumber - 1;
        if (collected[index]) {
            System.out.println("Clue #" + clueNumber + " has already been collected!");
            return false;
        }

        collected[index] = true;
        System.out.println("Clue #" + clueNumber + " collected: \"" + clues[index] + "\"");
        return true;
    }

    // Method to display all collected clues
    public void displayCollectedClues() {
        System.out.println("\n========== COLLECTED CLUES ==========");
        boolean anyCollected = false;

        for (int i = 0; i < clues.length; i++) {
            if (collected[i]) {
                System.out.println("- Clue #" + (i + 1) + ": " + clues[i]);
                anyCollected = true;
            }
        }

        if (!anyCollected) {
            System.out.println("No clues have been collected yet.");
        }
    }
}