package view;

import java.util.Scanner;

public class ConsoleView {
    public void displayMenu() {
        System.out.println("1. Normalize Text");
        System.out.println("2. Exit");
    }

    public int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}