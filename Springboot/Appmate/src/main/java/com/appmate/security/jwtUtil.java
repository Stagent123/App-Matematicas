package com.appmate.security;

import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;


@Component
public class JwtUtil {
    //Cambiar luego para fase de Final
    private static final String SECRET_KEY = "Clave-Super-Secreta-1234-Con-Caracteres-Extra";

    private static final long EXPIRATION_MS = 15 * 60 * 1000;

    public String generateToken(String username) {
        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
        return Jwts.builder()
            .subject(username)
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
            .signWith(key, Jwts.SIG.HS256) // Usamos la interfaz SIG estandarizada
            .compact();
    }
    public String extractUsername(String token){
        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
        return Jwts.parser()
            .verifyWith(key) // En las versiones modernas de JJWT se usa verifyWith
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();
    }
}
