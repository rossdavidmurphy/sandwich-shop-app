package models;

import enums.BreadType;
import enums.SandwichSize;

import java.util.ArrayList;
import java.util.List;
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
            case FOUR_INCH -> 4.00;
            case EIGHT_INCH -> 6.00;
            case TWELVE_INCH -> 8.00;
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

    @Override
    public double getPrice() {
        double getPremiumCharges = toppings.stream()
                .mapToDouble(Topping::getPremiumCharge)
                .sum();
        return basePrice + getPremiumCharges;
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
