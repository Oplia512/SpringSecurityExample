package com.example.demo.service;

import com.google.common.io.BaseEncoding;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Component
public class TokenHandler {

    private final SecretKey secretKey;

    public TokenHandler() {
        String jwtKey = "jwtKey13224334";
        byte[] decodedKey = BaseEncoding.base64().decode(jwtKey);
        secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
    }

    public Optional<ObjectId> extractUserId(String token) {
        try{
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            Claims body = claimsJws.getBody();
            return Optional.ofNullable(body.getId()).map(ObjectId::new);

        } catch (Exception e){
            return Optional.empty();
        }
    }

    public String generateAccessToken(@NonNull ObjectId objectId, LocalDateTime localDateTime) {
        return Jwts.builder()
                .setId(objectId.toString())
                .setExpiration(Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }
}
