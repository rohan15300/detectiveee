/**
 * Student 4: Main Program and Integration
 * Integrates all modules and controls the execution flow using predefined choices.
 */
public class DetectiveGame {

    public static void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("       DETECTIVE INVESTIGATION");
        System.out.println("========================================");
        System.out.println("1. View Suspects");
        System.out.println("2. Investigate Suspect");
        System.out.println("3. Collect Clue");
        System.out.println("4. View Collected Clues");
        System.out.println("5. Accuse Suspect");
        System.out.println("6. Exit");
        System.out.println("========================================");
    }

    public static void main(String[] args) {
        // Step 1: Initialize all components
        Suspect[] suspects = Suspect.initializeSuspects();
        ClueManager clueManager = new ClueManager();
        Investigation investigation = new Investigation(suspects);

        // Predefined simulation script executing each required menu path
        // Option numbers: 1, 2, 3, 4, 5, 6
        int[] simulatedMenuChoices = { 1, 2, 2, 4, 3, 3, 3, 4, 2, 5, 5, 6 };
        int step = 0;

        boolean running = true;

        // Loop to repeat the investigation until exit or completion
        while (running && step < simulatedMenuChoices.length) {
            displayMenu();
            int choice = simulatedMenuChoices[step];
            System.out.println("Predefined selection: Option " + choice);

            // Switch statement for menu selection
            switch (choice) {
                case 1:
                    Suspect.displayAllSuspects(suspects);
                    break;

                case 2:
                    if (step == 1) {
                        investigation.searchSuspect(3); // Investigate Rahul
                    } else if (step == 2) {
                        investigation.searchSuspect(9); // Test invalid suspect ID
                    } else {
                        investigation.searchSuspect(5); // Investigate Arjun
                    }
                    break;

                case 3:
                    if (step == 4) {
                        clueManager.collectClue(1); // Door opened at 2:15 PM
                    } else if (step == 5) {
                        clueManager.collectClue(4); // ID card found
                    } else if (step == 6) {
                        clueManager.collectClue(1); // Test duplicate prevention
                    }
                    break;

                case 4:
                    clueManager.displayCollectedClues();
                    break;

                case 5:
                    if (step == 9) {
                        investigation.accuseSuspect(2); // Incorrect accusation (Maya)
                    } else if (step == 10) {
                        investigation.accuseSuspect(5); // Correct accusation (Arjun)
                    }
                    break;

                case 6:
                    System.out.println("\nExiting the investigation. Goodbye, Detective!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid selection.");
                    break;
            }

            step++;
        }
    }
}