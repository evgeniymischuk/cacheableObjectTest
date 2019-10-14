package utils.enums;

public enum StrategyType {

    LRU("Least Recently Used"),
    LFU("Least Frequently Used");

    private final String description;

    StrategyType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "StrategyType " + description;
    }
}
