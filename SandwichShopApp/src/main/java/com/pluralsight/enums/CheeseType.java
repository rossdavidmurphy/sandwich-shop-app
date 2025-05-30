package com.pluralsight.enums;

public enum CheeseType {
    AMERICAN,
    PROVOLONE,
    CHEDDAR,
    SWISS;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
