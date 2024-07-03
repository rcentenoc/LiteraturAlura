package com.literaturalura.literaturalura.model;

public enum Language {
    SPANISH("es"),
    ENGLISH("en"),
    FRENCH("fr"),
    GERMAN("de"),
    ITALIAN("it"),
    PORTUGUESE("pt"),
    DUTCH("nl"),
    FINNISH("fi"),
    GREEK("el"),
    HUNGARIAN("hu"),
    LATIN("la"),
    POLISH("pl"),
    RUSSIAN("ru"),
    SWEDISH("sv"),
    TURKISH("tr");

    private final String language;

    private Language(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public static Language valueOfLanguage(String languageAcr) {
        for (Language lang : Language.values()) {
            if (lang.getLanguage().equals(languageAcr)) {
                return lang;
            }
        }
        return null;
    }

}
