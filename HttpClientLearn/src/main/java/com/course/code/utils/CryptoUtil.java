package com.course.code.utils;


import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.symmetric.AES;
import com.course.config.ConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.UUID;

public class CryptoUtil {
    private static final Logger logger = LoggerFactory.getLogger(CryptoUtil.class);

    // 从配置读取密钥
    private static final String AES_KEY = ConfigManager.get("crypto.aes.key");
    private static final String RSA_PUBLIC_KEY_RAW = ConfigManager.get("crypto.rsa.publicKey");
    private static final String APP_SECRET = ConfigManager.get("crypto.app.secret");

    /**
     * AES 加密
     */

    public static String encryptAES(String content) {
        if (content == null) return null;
        AES aes = SecureUtil.aes(AES_KEY.getBytes(StandardCharsets.UTF_8));
        return aes.encryptBase64(content);
    }

    /**
     * RSA 加密 (修复版：兼容 Hutool 5.8.26)
     * 核心逻辑：手动解析 PublicKey 对象，避免构造函数歧义
     */

    public static String encryptRSA(String content) {
        if (content == null) return null;
        if (RSA_PUBLIC_KEY_RAW == null || RSA_PUBLIC_KEY_RAW.trim().isEmpty()) {
            throw new RuntimeException("RSA Public Key not configured");
        }

        try {
            // 1. 清洗公钥字符串
            String cleanBase64 = RSA_PUBLIC_KEY_RAW.replaceAll("[^A-Za-z0-9+/]", "");

            // 2. 【兼容写法】使用 JDK 原生方式解析 PublicKey，不依赖 Hutool 新版本
            byte[] keyBytes = java.util.Base64.getDecoder().decode(cleanBase64);
            java.security.spec.X509EncodedKeySpec spec = new java.security.spec.X509EncodedKeySpec(keyBytes);
            java.security.KeyFactory keyFactory = java.security.KeyFactory.getInstance("RSA");
            java.security.PublicKey publicKey = keyFactory.generatePublic(spec);

            // 3. 初始化 RSA (传入解析好的对象)
            RSA rsa = new RSA(null, publicKey);

            // 4. 执行加密
            byte[] encryptedBytes = rsa.encrypt(content.getBytes(StandardCharsets.UTF_8), cn.hutool.crypto.asymmetric.KeyType.PublicKey);

            // 5. 返回 Base64 (使用 JDK 原生或 Hutool 均可，这里用 JDK 确保万无一失)
            return java.util.Base64.getEncoder().encodeToString(encryptedBytes);

        } catch (Exception e) {
            logger.error("RSA 加密失败!", e);
            throw new RuntimeException("RSA 加密失败: " + e.getMessage(), e);
        }
    }

    @Test
    public void testersa(){
        String li = encryptRSA("li");
        System.out.println(li);
    }

    /**
     * 生成接口签名
     */
    public static String generateSignature(Map<String, Object> params) {
        if (params == null) return "";

        // 1. 过滤掉 sign 字段本身和值为 null 的字段
        Map<String, Object> sortedParams = new TreeMap<>(params);
        sortedParams.remove("sign");
        sortedParams.values().removeIf(Objects::isNull);

        // 2. 拼接字符串 key1=value1&key2=value2...
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : sortedParams.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        // 3. 拼接密钥 (注意：有些后端要求 key=secret 放在最后，有些是直接拼接 secret，请根据后端文档调整)
        sb.append("key=").append(APP_SECRET);

        String rawString = sb.toString();
        logger.debug("Sign Raw String: {}", rawString);

        // 默认 MD5，如需 SHA256 请切换
        return DigestUtil.md5Hex(rawString);
    }

    /**
     * 处理时间戳和随机数
     */
    public static void addCommonSignParams(Map<String, Object> params) {
        if (params == null) return;
        params.put("timestamp", System.currentTimeMillis());
        params.put("nonce", UUID.randomUUID().toString().replace("-", ""));
    }
}