package ro.helator.gameprofiler.service.model;

public enum LanguageEnum {
    FR("fr"), EN_US("en_US"), EN_GB("en_GB");

    private final String code;

    LanguageEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
