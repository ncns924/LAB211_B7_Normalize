package main;

import controller.TextNormalizerController;
import model.TextNormalizer;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        TextNormalizer model = new TextNormalizer("input.txt", "output.txt");
        ConsoleView view = new ConsoleView();
        TextNormalizerController controller = new TextNormalizerController(model, view);

        controller.processUserInput();
    }
}
