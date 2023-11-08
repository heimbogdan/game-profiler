package ro.helator.gameprofiler.service.model;

public enum CredentialEnum {
    APPLE("apple_credential"), GOOGLE("google_credential"), EMAIL("email_credential");
    private final String type;

    CredentialEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
