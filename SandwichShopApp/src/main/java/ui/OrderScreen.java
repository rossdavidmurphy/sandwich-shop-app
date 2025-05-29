package ui;

import enums.*;
import models.*;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class OrderScreen {
    private final Scanner input = new Scanner(System.in);
    private final Order order = new Order();

    public void running() {
        while (true) {
            System.out.println("\n-- Order Screen --");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            String input = this.input.nextLine();

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
        System.out.println("What size sandwich would you like?");
            SandwichSize[] sizes = SandwichSize.values();
            for (int i = 0; i < sizes.length; i++) {
                System.out.printf("%d) %s%n", i + 1, sizes[i]);
            }
            int sizeChoice = Integer.parseInt(input.nextLine());
            SandwichSize size = sizes[sizeChoice - 1];

            System.out.println("Choose bread type:");
            BreadType[] breads = BreadType.values();
            for (int i = 0; i < breads.length; i++) {
                System.out.printf("%d) %s%n", i + 1, breads[i]);
            }
            int breadChoice = Integer.parseInt(input.nextLine());
            BreadType bread = breads[breadChoice - 1];

            System.out.print("Would you like it toasted? (Yes/No): ");
            String toastInput = input.nextLine();
            boolean toasted = toastInput.equalsIgnoreCase("yes");

            Sandwich sandwich = new Sandwich(size, bread, toasted);

            while (true) {
                System.out.println("\nChoose a topping to add:");
                ToppingType[] toppingTypes = ToppingType.values();
                for (int i = 0; i < toppingTypes.length; i++) {
                    System.out.printf("%d) %s%n", i + 1, toppingTypes[i]);
                }
                System.out.println("0) Done adding toppings");

                String input = input.nextLine();
                if (input.equals("0")) break;

                try {
                    int toppingChoice = Integer.parseInt(input);
                    ToppingType selectedType = toppingTypes[toppingChoice - 1];

                    System.out.print("Enter name of the topping (e.g., Ham, Swiss, Mayo): ");
                    String toppingName = input.nextLine();
                    sandwich.addTopping(new Topping(toppingName, selectedType));

                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                }
            }

            order.addItem(sandwich);
            System.out.println("Your sandwich has been added to your order.");
        }
    }

    private void addDrink() {
        System.out.println("What size drink would you like?");
        DrinkSize[] sizes = DrinkSize.values();
        for (int i = 0; i < sizes.length; i++) {
            System.out.printf("%d) %s - $%.2f%n", i + 1, sizes[i], sizes[i].getPrice());
        }
        int sizeChoice = Integer.parseInt(input.nextLine());
        DrinkSize size = sizes[sizeChoice - 1];

        System.out.println("What drink would you like?");
        DrinkType[] types = DrinkType.values();
        for (int i = 0; i < types.length; i++) {
            System.out.printf("%d) %s%n", i + 1, types[i]);
        }
        int typeChoice = Integer.parseInt(input.nextLine());
        DrinkType drinkType = types[typeChoice - 1];

        System.out.println("How would you like your ice?");
        IceType[] iceTypes = IceType.values();
        for (int i = 0; i < iceTypes.length; i++) {
            System.out.printf("%d) %s%n", i + 1, iceTypes[i]);
        }
        int iceChoice = Integer.parseInt(input.nextLine());
        IceType iceType = iceTypes[iceChoice - 1];

        Drink drink = new Drink(drinkType.toString(), size.getPrice(), size, drinkType, iceType);
        order.addItem(drink);

        System.out.println("Your drink has been added to your order.");
    }

    private void addChips() {
        System.out.println("What chips would you like?");
        ChipType[] chipTypes = ChipType.values();
        for (int i = 0; i < chipTypes.length; i++) {
            System.out.printf("%d) %s%n", i + 1, chipTypes[i]);
        }

        try {
            int choice = Integer.parseInt(input.nextLine());
            ChipType selectedType = chipTypes[choice - 1];

            Chips chips = new Chips(selectedType);
            order.addItem(chips);

            System.out.println("Your chips have been added to your order.");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
    }

        private void saveReceipt() {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            String dateTime = LocalDateTime.now().format(dateTimeFormatter);

//            String receiptName = "receipts/" + dateTime + ".txt";

            FileWriter fileWriter = new FileWriter(receiptName);
            fileWriter.write(order.getOrderDetails());
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("Error: Receipt not saved. ");
        }

    private void checkout() {
        System.out.println("\n-- Checkout --");
        System.out.println(order.getOrderDetails());

        System.out.print("Confirm order? (Yes/No): ");
        String confirm = input.nextLine();

        if (confirm.equalsIgnoreCase("Yes")) {
            saveReceipt();
            System.out.println("Thank you for your order.");
        } else {
            System.out.println("Order cancelled.");
        }

        System.out.println("Returning to home screen.");
    }
}
