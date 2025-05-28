package enums;

public enum ChipType {
    TRADITIONAL("Traditional"),
    RUFFLES("Ruffles"),
    BBQ("Barbecue"),
    SOUR_CREAM_ONION("Sour Cream & Onion"),
    LIGHTLY_SALTED("Lightly Salted");

    private final String displayName;

    ChipType(String displayName) {
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
