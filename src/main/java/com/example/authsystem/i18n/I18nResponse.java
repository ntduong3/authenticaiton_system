package com.example.authsystem.i18n;

import java.util.Map;

public record I18nResponse(String locale, Map<String, String> messages) {
}
