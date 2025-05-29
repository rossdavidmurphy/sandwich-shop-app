package models;

import enums.BreadType;
import enums.SandwichSize;
import enums.ToppingType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sandwich extends MenuItem {
    private SandwichSize size;
    private BreadType bread;
    private boolean toasted;
    private List<Topping> toppings;

    public Sandwich(SandwichSize size, BreadType bread, boolean toasted) {
        super(size.getLength() + "\" Sandwich", getBasePriceBySize(size));
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
        this.toppings = new ArrayList<>();
    }

    private static double getBasePriceBySize(SandwichSize size) {
        return switch (size) {
            case FOUR_INCH -> 5.50;
            case EIGHT_INCH -> 7.00;
            case TWELVE_INCH -> 8.50;
        };
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public SandwichSize getSize() {
        return size;
    }

    public BreadType getBread() {
        return bread;
    }

    public boolean isToasted() {
        return toasted;
    }

    private static final Map<SandwichSize, Double> MEAT_BASE_PRICES = Map.of(
            SandwichSize.FOUR_INCH, 1.00,
            SandwichSize.EIGHT_INCH, 2.00,
            SandwichSize.TWELVE_INCH, 3.00
    );

    private static final Map<SandwichSize, Double> MEAT_EXTRA_PRICES = Map.of(
            SandwichSize.FOUR_INCH, 0.50,
            SandwichSize.EIGHT_INCH, 1.00,
            SandwichSize.TWELVE_INCH, 1.50
    );

    private static final Map<SandwichSize, Double> CHEESE_BASE_PRICES = Map.of(
            SandwichSize.FOUR_INCH, 0.75,
            SandwichSize.EIGHT_INCH, 1.50,
            SandwichSize.TWELVE_INCH, 2.25
    );

    private static final Map<SandwichSize, Double> CHEESE_EXTRA_PRICES = Map.of(
            SandwichSize.FOUR_INCH, 0.30,
            SandwichSize.EIGHT_INCH, 0.60,
            SandwichSize.TWELVE_INCH, 0.90
    );

    @Override
    public double getPrice() {
        Map<ToppingType, Long> counts = toppings.stream()
                .collect(Collectors.groupingBy(Topping::getType, Collectors.counting()));

        double meatCharge = 0.0;
        long meatCount = counts.getOrDefault(ToppingType.MEAT, 0L);
        if (meatCount > 0) {
            meatCharge += MEAT_BASE_PRICES.get(size);
            meatCharge += (meatCount - 1) * MEAT_EXTRA_PRICES.get(size);
        }

        double cheeseCharge = 0.0;
        long cheeseCount = counts.getOrDefault(ToppingType.CHEESE, 0L);
        if (cheeseCount > 0) {
            cheeseCharge += CHEESE_BASE_PRICES.get(size);
            cheeseCharge += (cheeseCount - 1) * CHEESE_EXTRA_PRICES.get(size);
        }

        return basePrice + meatCharge + cheeseCharge;
    }

    @Override
    public String getDetails() {
        String toppingList = toppings.stream()
                .map(Topping::toString)
                .collect(Collectors.joining(", "));

        return String.format("%s on %s (%s)%s - $%.2f",
                name,
                bread,
                toasted ? "Toasted" : "Not Toasted",
                toppingList.isEmpty() ? "" : "\n  Toppings: " + toppingList,
                getPrice()
        );
    }
}
