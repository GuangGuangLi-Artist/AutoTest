
package com.gpt.utils;

import java.util.HashMap;
import java.util.Map;

public class TokenManager {
    private static Map<String, String> tokenMap = new HashMap<>();

    public static void setToken(String key, String token) {
        tokenMap.put(key, token);
    }

    public static String getToken(String key) {
        return tokenMap.getOrDefault(key, "");
    }

    public static void injectToken(Map<String, String> headers, String key) {
        String token = getToken(key);
        if (!token.isEmpty()) {
            headers.put("Authorization", "Bearer " + token);
        }
    }
}
