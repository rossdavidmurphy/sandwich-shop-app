package models;

public abstract class MenuItem {
    private String name;
    private double basePrice;

    public MenuItem(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public abstract double getPrice();
    public abstract String getDetails();

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return getDetails();
    }
}
