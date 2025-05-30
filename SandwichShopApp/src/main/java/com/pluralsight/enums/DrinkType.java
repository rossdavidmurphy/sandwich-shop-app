package com.pluralsight.enums;

public enum DrinkType {
    COKE_COLA("Coke-Cola"),
    DR_PEPPER("Dr Pepper"),
    ORANGE_FANTA("Orange Fanta"),
    LEMONADE("Lemonade"),
    COFFEE("Coffee"),
    SWEET_TEA("Sweet Tea"),
    WATER("Water");

    private final String displayName;

    DrinkType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
