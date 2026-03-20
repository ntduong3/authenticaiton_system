package com.example.authsystem.controller.api;

import com.example.authsystem.i18n.I18nResponse;
import com.example.authsystem.i18n.I18nService;
import java.time.Duration;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class I18nController {

    private static final CacheControl CACHE_CONTROL = CacheControl.maxAge(Duration.ofHours(1)).cachePublic();

    private final I18nService i18nService;

    public I18nController(I18nService i18nService) {
        this.i18nService = i18nService;
    }

    @GetMapping("/i18n")
    public ResponseEntity<I18nResponse> getTranslations(@RequestParam(defaultValue = "en") String locale) {
        return ResponseEntity.ok()
                .cacheControl(CACHE_CONTROL)
                .body(i18nService.getTranslations(locale));
    }
}
