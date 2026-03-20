package com.course.code.utils;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.RSA;

public class KeyGenerator{
    public static void main(String[] args) {
        // 生成 RSA 密钥对 (2048位)
        RSA rsa = SecureUtil.rsa();

        String publicKeyBase64 = rsa.getPublicKeyBase64();
        String privateKeyBase64 = rsa.getPrivateKeyBase64();

        System.out.println("=== 请复制以下公钥到配置文件 (crypto.rsa.publicKey) ===");
        System.out.println(publicKeyBase64);
        System.out.println("\n=== 请妥善保存以下私钥 (用于解密) ===");
        System.out.println(privateKeyBase64);
    }
}
