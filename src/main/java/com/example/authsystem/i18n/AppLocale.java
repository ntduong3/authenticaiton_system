package com.example.authsystem.i18n;

import java.util.Arrays;
import java.util.Locale;

public enum AppLocale {
    EN("en", Locale.ENGLISH),
    VI("vi", Locale.forLanguageTag("vi"));

    private final String code;
    private final Locale locale;

    AppLocale(String code, Locale locale) {
        this.code = code;
        this.locale = locale;
    }

    public String getCode() {
        return code;
    }

    public Locale getLocale() {
        return locale;
    }

    public static AppLocale fromCode(String code) {
        if (code == null || code.isBlank()) {
            return EN;
        }

        return Arrays.stream(values())
                .filter(value -> value.code.equalsIgnoreCase(code.trim()))
                .findFirst()
                .orElse(EN);
    }
}
