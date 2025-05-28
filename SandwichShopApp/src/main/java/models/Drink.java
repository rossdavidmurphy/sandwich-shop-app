package models;

import enums.DrinkFlavor;
import enums.DrinkSize;

public class Drink extends MenuItem {
    private DrinkSize size;
    private DrinkFlavor flavor;

    public Drink(DrinkSize size, DrinkFlavor flavor) {
        super(size.toString() + " " + flavor.toString(), size.getPrice());
        this.size = size;
        this.flavor = flavor;
    }

    public DrinkSize getSize() {
        return size;
    }

    public DrinkFlavor getFlavor() {
        return flavor;
    }

    @Override
    public double getPrice() {
        return basePrice;
    }

    @Override
    public String getDetails() {
        return String.format("%s (%s) - $%.2f", flavor, size,getPrice());
    }
}
