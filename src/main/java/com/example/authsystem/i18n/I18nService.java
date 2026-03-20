package com.example.authsystem.i18n;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class I18nService {

    private static final List<String> MESSAGE_CODES = List.of(
            "app.title",
            "nav.login",
            "nav.register",
            "auth.login.title",
            "auth.login.subtitle",
            "auth.login.button",
            "auth.register.title",
            "auth.register.subtitle",
            "auth.register.button",
            "auth.logout.button",
            "dashboard.title",
            "dashboard.subtitle"
    );

    private final MessageSource messageSource;
    private final Map<AppLocale, Map<String, String>> cache = new ConcurrentHashMap<>();

    public I18nService(MessageSource messageSource) {
        this.messageSource = messageSource;
        warmUpCache();
    }

    public I18nResponse getTranslations(String localeCode) {
        AppLocale locale = AppLocale.fromCode(localeCode);
        Map<String, String> messages = cache.computeIfAbsent(locale, this::loadTranslations);
        return new I18nResponse(locale.getCode(), messages);
    }

    private void warmUpCache() {
        for (AppLocale locale : AppLocale.values()) {
            cache.put(locale, loadTranslations(locale));
        }
    }

    private Map<String, String> loadTranslations(AppLocale locale) {
        Map<String, String> messages = new LinkedHashMap<>();
        for (String code : MESSAGE_CODES) {
            messages.put(code, messageSource.getMessage(code, null, locale.getLocale()));
        }
        return Collections.unmodifiableMap(messages);
    }
}
