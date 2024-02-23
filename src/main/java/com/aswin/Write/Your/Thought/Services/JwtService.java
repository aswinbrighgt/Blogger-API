package com.aswin.Write.Your.Thought.Services;

import com.aswin.Write.Your.Thought.Models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Service
public class JwtService {

    private final String secret_key="ab82f717ac47a92ddc81813e94e9b0017420969f091e9483f2e2701ad7c05d55";

    public String generateToken(UserDetails user){
        return Jwts
                .builder()
                .subject(user.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60*60*24))
                .signWith(getSigninkey())
                .compact();
    }

    public boolean isValid(String token,UserDetails user){
        return (!new Date().before(getExpiration(token))&&
                (getUserName(token).equals(user.getUsername())));
    }
    public Date getExpiration(String token){
        return claimExtractor(token,Claims::getExpiration);
    }
    public String getUserName(String token){
        return claimExtractor(token,Claims::getSubject);
    }

    public <T> T claimExtractor(String token, Function<Claims,T> resolver){
        Claims claims=extractAllClaims(token);
        return resolver.apply(claims);
    }

    public Claims extractAllClaims(String token){
        return Jwts
                .parser()
                .verifyWith(getSigninkey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public SecretKey getSigninkey(){
        byte[] keyByte= Decoders.BASE64.decode(secret_key);
        return Keys.hmacShaKeyFor(keyByte);
    }
}
