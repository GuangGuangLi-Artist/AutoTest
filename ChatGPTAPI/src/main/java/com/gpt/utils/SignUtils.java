
package com.gpt.utils;

import java.security.MessageDigest;
import java.util.Map;
import java.util.TreeMap;

public class SignUtils {
    public static String generateSignature(Map<String, String> params, String secretKey) {
        try {
            // TreeMap 自动按 key 排序
            TreeMap<String, String> sorted = new TreeMap<>(params);
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : sorted.entrySet()) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            sb.append("key=").append(secretKey);

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(sb.toString().getBytes("UTF-8"));
            StringBuilder hex = new StringBuilder();
            for (byte b : digest) {
                hex.append(String.format("%02x", b & 0xff));
            }
            return hex.toString().toUpperCase();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
