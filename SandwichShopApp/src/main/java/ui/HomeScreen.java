package ui;

import java.util.Scanner;

public class HomeScreen {
    private final Scanner input = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n=== Welcome to The Sandwich Shop ===");
            System.out.println("1) Start New Order");
            System.out.println("0) Exit");

            System.out.print("Choose an option: ");
            String input = input.nextLine();

            switch (input) {
                case "1" -> {
                    OrderScreen orderScreen = new OrderScreen();
                    orderScreen.running();
                }
                case "0" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
