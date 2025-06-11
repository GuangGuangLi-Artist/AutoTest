package com.course.code.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenGenerator {

    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private static final long EXPIRATION_TIME = 3600000;

    public static String generateJwtToken(String username, Map<String, Object> claims) {
        return Jwts.builder()
                .setSubject(username)
                .addClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY)
                .compact();
    }

    public static Jws<Claims> parseJwtToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token);
    };

    public static String verifyJwtToken(String token) {
        Jws<Claims> claims = parseJwtToken(token);
        return claims.getBody().getSubject();
    }

    public static void main(String[] args) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "admin");
        claims.put("department", "IT");

        String guangguangjsonToken = generateJwtToken("guangguangjson", claims);
        System.out.println(guangguangjsonToken);

        String verifyguangguangjsonJwtToken = verifyJwtToken(guangguangjsonToken);
        System.out.println(verifyguangguangjsonJwtToken);
    }
}
