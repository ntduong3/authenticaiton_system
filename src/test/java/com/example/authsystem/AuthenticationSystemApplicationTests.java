package com.example.authsystem;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(properties = "spring.session.store-type=none")
@AutoConfigureMockMvc
class AuthenticationSystemApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldReturnVietnameseTranslations() throws Exception {
        mockMvc.perform(get("/i18n").param("locale", "vi"))
                .andExpect(status().isOk())
                .andExpect(header().string("Cache-Control", org.hamcrest.Matchers.containsString("max-age")))
                .andExpect(jsonPath("$.locale").value("vi"))
                .andExpect(jsonPath("$.messages['auth.login.title']").value("Dang nhap"))
                .andExpect(jsonPath("$.messages['auth.logout.button']").value("Dang xuat"));
    }

    @Test
    void shouldFallbackToEnglishForUnsupportedLocale() throws Exception {
        mockMvc.perform(get("/i18n").param("locale", "jp"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.locale").value("en"))
                .andExpect(jsonPath("$.messages['auth.login.title']").value("Login"))
                .andExpect(jsonPath("$.messages['dashboard.title']").value("Dashboard"));
    }
}
