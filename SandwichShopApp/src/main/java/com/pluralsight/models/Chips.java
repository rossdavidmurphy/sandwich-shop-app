package com.pluralsight.models;

import com.pluralsight.enums.ChipType;

public class Chips extends MenuItem {
    private ChipType type;

    public Chips(ChipType type) {
        super(type.toString() + " Chips", 1.50);
        this.type = type;
    }

    public ChipType getType() {
        return type;
    }

    @Override
    public double getPrice() {
        return basePrice;
    }

    @Override
    public String getDetails() {
        return String.format("%s Chips - $%.2f", type, getPrice());
    }
}
