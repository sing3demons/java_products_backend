package com.sing3demons.products_backend.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sing3demons.products_backend.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    @Value("${app.token.secret}")
    private String secret;

    @Value("${app.token.issuer}")
    private String issuer;

    private long expiration_time = 86_400_000;

    public String tokenize(User user) {
        String token = JWT.create().withIssuer(issuer).withSubject(user.getId()).withClaim("role", "USER").withExpiresAt(new Date(System.currentTimeMillis() + expiration_time)).sign(algorithm());
        return token;
    }

    public DecodedJWT verify(String token) {
        try {
            JWTVerifier verifier = JWT.require(algorithm()).withIssuer(issuer).build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt;
        } catch (Exception ex) {
            return null;
        }
    }

    private Algorithm algorithm() {
        return Algorithm.HMAC256(secret);
    }
}
