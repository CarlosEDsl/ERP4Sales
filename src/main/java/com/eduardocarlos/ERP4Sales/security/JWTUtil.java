package com.eduardocarlos.ERP4Sales.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Objects;

@Component
public class JWTUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expiration;

    public SecretKey getKeyBySecret(){
        return Keys.hmacShaKeyFor(this.secret.getBytes());
    }

    public String generateToken(String login){

        SecretKey key = getKeyBySecret();

        return Jwts.builder()
                .setSubject(login)
                .signWith(key)
                .setExpiration(new Date(System.currentTimeMillis() + this.expiration))
                .compact();
    }

    //Token verification
    public boolean isValidToken(String token) {
        Claims claims = getClaims(token);
        if(Objects.nonNull(claims)){
            String login = claims.getSubject();
            Date expirationDate = claims.getExpiration();
            Date now = new Date(System.currentTimeMillis());

            return Objects.nonNull(login) && Objects.nonNull(expirationDate) && now.before(expirationDate); //return true if successful;
        }
        return false;
    }

    private Claims getClaims(String token) {
        SecretKey key = getKeyBySecret();

        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e){
            return null;
        }
    }

}
