package com.pluralsight.ui;

import com.pluralsight.enums.*;
import com.pluralsight.models.*;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class OrderScreen {
    private final Scanner input = new Scanner(System.in);
    private final Order order = new Order();

    public void display() {
        while (true) {
            System.out.println("\n-- Order Screen --");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            String choice = this.input.nextLine();

            switch (choice) {
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

                int choice = Integer.parseInt(input.nextLine());
                if (choice == 0) break;

                try {
                    ToppingType toppingType = toppingTypes[choice - 1];

                    switch (toppingType) {
                        case MEAT -> {
                            MeatType[] meats = MeatType.values();
                            for (int i = 0; i < meats.length; i++) {
                                System.out.printf("%d) %s%n", i + 1, meats[i]);
                            }
                            System.out.print("Choose a meat: ");
                            int meatChoice = Integer.parseInt(input.nextLine());
                            String meatName = meats[meatChoice - 1].toString();
                            sandwich.addTopping(new Topping(meatName, ToppingType.MEAT));
                        }

                        case CHEESE -> {
                            CheeseType[] cheeses = CheeseType.values();
                            for (int i = 0; i < cheeses.length; i++) {
                                System.out.printf("%d) %s%n", i + 1, cheeses[i]);
                            }
                            System.out.print("Choose a cheese: ");
                            int cheeseChoice = Integer.parseInt(input.nextLine());
                            String cheeseName = cheeses[cheeseChoice - 1].toString();
                            sandwich.addTopping(new Topping(cheeseName, ToppingType.CHEESE));
                        }

                        case SAUCE -> {
                            SauceType[] sauces = SauceType.values();
                            for (int i = 0; i < sauces.length; i++) {
                                System.out.printf("%d) %s%n", i + 1, sauces[i]);
                            }
                            System.out.print("Choose a sauce: ");
                            int sauceChoice = Integer.parseInt(input.nextLine());
                            String sauceName = sauces[sauceChoice - 1].toString();
                            sandwich.addTopping(new Topping(sauceName, ToppingType.SAUCE));
                        }

                        case REGULAR -> {
                            RegularType[] regulars = RegularType.values();
                            for (int i = 0; i < regulars.length; i++) {
                                System.out.printf("%d) %s%n", i + 1, regulars[i]);
                            }
                            System.out.print("Choose a topping: ");
                            int regularChoice = Integer.parseInt(input.nextLine());
                            String regularName = regulars[regularChoice - 1].toString();
                            sandwich.addTopping(new Topping(regularName, ToppingType.REGULAR));
                        }
                    }

                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                    input.nextLine();
                }
            }

            order.addItem(sandwich);
            System.out.println("Your sandwich has been added to your order.");
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

        Drink drink = new Drink(size, drinkType, iceType);
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
    }

    private void saveReceipt() {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            String receiptName = LocalDateTime.now().format(dateTimeFormatter);

            String filePath = "receipts/" + receiptName + ".txt";

            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(order.getOrderDetails());
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("Error: Receipt not saved. ");
        }
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

        HomeScreen homeScreen = new HomeScreen();
        homeScreen.display();
    }
}