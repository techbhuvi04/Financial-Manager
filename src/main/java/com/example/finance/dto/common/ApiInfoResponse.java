package com.example.finance.dto.common;

import java.util.Map;

/**
 * Public description of the API returned from its base URL.
 *
 * @param name          service name
 * @param status        always {@code "UP"} when the service can answer
 * @param message       how to get started
 * @param documentation path of the interactive API documentation
 * @param endpoints     main endpoint groups, keyed by purpose
 */
public record ApiInfoResponse(String name, String status, String message, String documentation,
                              Map<String, String> endpoints) {
}
