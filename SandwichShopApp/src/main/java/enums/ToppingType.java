package enums;

public enum ToppingType {
    MEAT,
    CHEESE,
    SAUCE,
    REGULAR;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
