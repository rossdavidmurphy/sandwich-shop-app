package models;

import enums.SandwichSize;
import enums.ToppingType;

public class Topping {
    private String name;
    private ToppingType type;

    public Topping(String name, ToppingType type, boolean extra) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public ToppingType getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }
}
