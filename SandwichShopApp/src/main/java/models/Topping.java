package models;

import enums.ToppingType;

public class Topping {
    private String name;
    private ToppingType type;
    private boolean extra;

    public Topping(String name, ToppingType type, boolean extra) {
        this.name = name;
        this.type = type;
        this.extra = extra;
    }

    public String getName() {
        return name;
    }

    public ToppingType getType() {
        return type;
    }

    public boolean isExtra() {
        return extra;
    }

    public double getPremiumCharge() {
        if (type == ToppingType.PREMIUM) {
            return extra ? 2.00 : 1.00;
        }
        return 0.00;
    }

    @Override
    public String toString() {
        return (extra ? "Extra " : "") + name;
    }
}
