package enums;

public enum SandwichSize {
    FOUR_INCH(4),
    EIGHT_INCH(8),
    TWELVE_INCH(12);

    private final int length;

    SandwichSize(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
