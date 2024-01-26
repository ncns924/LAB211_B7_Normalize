package controller;

import java.io.IOException;

import model.TextNormalizer;
import view.ConsoleView;

public class TextNormalizerController {
    private TextNormalizer model;
    private ConsoleView view;

    public TextNormalizerController(TextNormalizer model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void processUserInput() {
        int choice;

        do {
            view.displayMenu();
            choice = view.getUserChoice();

            switch (choice) {
                case 1:
                    try {
                        model.normalizeText();
                        view.displayMessage("Text normalized successfully. Check output.txt.");
                    } catch (IOException e) {
                        view.displayMessage("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    view.displayMessage("Exiting program. Goodbye!");
                    break;

                default:
                    view.displayMessage("Invalid choice. Please try again.");
                    break;
            }

        } while (choice != 2);
    }
}
