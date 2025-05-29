package enums;

public enum IceType {
    NONE("No Ice"),
    LITE("Lite Ice"),
    EXTRA("Extra Ice");

    private final String displayName;

    IceType(String displayName) {
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
