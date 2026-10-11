package com.example.finance.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.finance.support.IntegrationTestBase;
import org.junit.jupiter.api.Test;

class ApiInfoIntegrationTest extends IntegrationTestBase {

    @Test
    void apiBaseUrlIsPublicAndDescribesTheApi() throws Exception {
        for (String path : new String[] {"/api", "/"}) {
            mockMvc.perform(get(path))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name").value("Personal Finance Manager API"))
                    .andExpect(jsonPath("$.status").value("UP"))
                    .andExpect(jsonPath("$.documentation").value("/swagger-ui.html"))
                    .andExpect(jsonPath("$.endpoints.transactions").value("/api/transactions"));
        }
    }

    @Test
    void otherEndpointsStillRequireAuthentication() throws Exception {
        mockMvc.perform(get("/api/transactions")).andExpect(status().isUnauthorized());
        mockMvc.perform(post("/api")).andExpect(status().isUnauthorized());
    }
}
