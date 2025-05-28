package enums;

public enum DrinkSize {
    SMALL(1.50),
    MEDIUM(2.00),
    LARGE(2.50);

    private final double price;

    DrinkSize(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
