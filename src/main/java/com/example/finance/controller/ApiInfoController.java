package com.example.finance.controller;

import com.example.finance.dto.common.ApiInfoResponse;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Public landing response for the service root and the API base URL, so opening them in a browser shows how to
 * use the API instead of an authentication error.
 */
@RestController
public class ApiInfoController {

    private static final ApiInfoResponse INFO = new ApiInfoResponse(
            "Personal Finance Manager API",
            "UP",
            "Register with POST /api/auth/register, then log in with POST /api/auth/login to get a session cookie.",
            "/swagger-ui.html",
            endpoints());

    /**
     * @return service name, status and the main endpoint groups
     */
    @GetMapping({"/", "/api"})
    public ApiInfoResponse info() {
        return INFO;
    }

    private static Map<String, String> endpoints() {
        Map<String, String> endpoints = new LinkedHashMap<>();
        endpoints.put("auth", "/api/auth/register, /api/auth/login, /api/auth/logout");
        endpoints.put("transactions", "/api/transactions");
        endpoints.put("categories", "/api/categories");
        endpoints.put("goals", "/api/goals");
        endpoints.put("reports", "/api/reports/monthly/{year}/{month}, /api/reports/yearly/{year}");
        endpoints.put("health", "/actuator/health");
        return Collections.unmodifiableMap(endpoints);
    }
}
