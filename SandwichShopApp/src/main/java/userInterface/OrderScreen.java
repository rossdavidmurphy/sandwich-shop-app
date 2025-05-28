package userInterface;

import models.Order;

import java.util.Scanner;

public class OrderScreen {
    private final Scanner scanner = new Scanner(System.in);
    private final Order order = new Order();

    public void running() {
        while (true) {
            System.out.println("\n-- Order Screen --");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            String input = scanner.nextLine();

            switch (input) {
                case "1" -> addSandwich();
                case "2" -> addDrink();
                case "3" -> addChips();
                case "4" -> checkout();
                case "0" -> {
                    System.out.println("Order cancelled.");
                    return;
                }
                default -> System.out.println("Invalid input.");
            }
        }
    }

    private void addSandwich() {
        // TODO: Walk user through sandwich building
        System.out.println("Adding sandwich...");
    }

    private void addDrink() {
        // TODO: Let user choose size and flavor
        System.out.println("Adding drink...");
    }

    private void addChips() {
        // TODO: Let user choose chip flavor
        System.out.println("Adding chips...");
    }

    private void checkout() {
        System.out.println("\n-- Checkout --");
        System.out.println(order.getOrderDetails());

        System.out.print("Confirm order? (y/n): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("y")) {
            // TODO: Save receipt
            System.out.println("Order confirmed. Receipt saved.");
        } else {
            System.out.println("Order cancelled.");
        }

        System.out.println("Returning to home screen.");
    }
}
