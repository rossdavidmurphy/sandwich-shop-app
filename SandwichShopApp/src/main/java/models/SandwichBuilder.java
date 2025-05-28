package models;

import enums.BreadType;
import enums.SandwichSize;

import java.util.ArrayList;
import java.util.List;

public class SandwichBuilder {
    private SandwichSize size;
    private BreadType breadType;
    private boolean toasted;
    private List<Topping> toppings = new ArrayList<>();

    public SandwichBuilder setSize(SandwichSize size) {
        this.size = size;
        return this;
    }

    public SandwichBuilder setBreadType(BreadType breadType) {
        this.breadType = breadType;
        return this;
    }

    public SandwichBuilder setToasted(boolean toasted) {
        this.toasted = toasted;
        return this;
    }

    public SandwichBuilder addToppings(Topping topping) {
        toppings.add(topping);
        return this;
    }

    public Sandwich build() {
        Sandwich sandwich = new Sandwich(size, breadType, toasted);
        for (Topping topping : toppings) {
            sandwich.addTopping(topping);
        }
        return sandwich;
    }
}
