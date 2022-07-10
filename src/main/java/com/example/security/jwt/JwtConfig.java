package com.example.security.jwt;

import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.crypto.SecretKey;

@NoArgsConstructor
@Setter
@Getter
@ConfigurationProperties(prefix = "app.jwt")
public class JwtConfig {
    private String secretKey;
    private String tokenPrefix;
    private Integer tokenExpirationAfterDays;

    public SecretKey getKeyForSigning(){
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
     public String getAuthorizationHeader(){
         return "Authorization";
     }
}
