package com.victor.commandexecutorservice.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {

    // En producción, esta clave debe venir de variables de entorno o un vault
    private static final String SECRET_KEY = "mi-clave-super-secreta-para-jwt-que-debe-ser-muy-larga";
    private static final long EXPIRATION_MS = 3600000; // 1 hora

    // Genera un token JWT
    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes())
                .compact();
    }

    // Extrae el username del token
    public static String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    // Valida si el token es correcto y no ha expirado
    public static boolean isTokenValid(String token) {
        try {
            Claims claims = getClaims(token);
            return claims.getExpiration().after(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    // Obtiene los claims del token
    private static Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(cleanToken(token))
                .getBody();
    }

    // Limpia el prefijo "Bearer " si viene incluido
    private static String cleanToken(String token) {
        if (token.startsWith("Bearer ")) {
            return token.substring(7);
        }
        return token;
    }
}