package models;

import enums.DrinkType;
import enums.DrinkSize;

public class Drink extends MenuItem {
    private DrinkSize size;
    private DrinkType type;

    public Drink(DrinkSize size, DrinkType flavor) {
        super(size.toString() + " " + flavor.toString(), size.getPrice());
        this.size = size;
        this.type = flavor;
    }

    public DrinkSize getSize() {
        return size;
    }

    public DrinkType getType() {
        return type;
    }

    @Override
    public double getPrice() {
        return basePrice;
    }

    @Override
    public String getDetails() {
        return String.format("%s (%s) - $%.2f", type, size,getPrice());
    }
}
