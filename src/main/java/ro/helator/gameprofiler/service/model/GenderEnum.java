package ro.helator.gameprofiler.service.model;

public enum GenderEnum {
    MALE("male"), FEMALE("female");
    private final String value;

    GenderEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
