package com.weather.security.jwt;
import io.jsonwebtoken.*;
import com.weather.security.userprincipal.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private final int jwtExpiration = 86400;

    private final String secretKey = "2F423F4528482B4D6251655468576D5A7134743777397A24432646294A404E63";

    public String generateToken(Authentication authentication) {

        UserPrincipal user = (UserPrincipal) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpiration * 1000L))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public boolean isValidToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            logger.error("Expired Token -> Message {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported Token -> Message {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Error Format Token -> Message {}", e.getMessage());
        } catch (SignatureException e) {
            logger.error("Error Signature Token -> Message {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("Claims Empty Token -> Message {}", e.getMessage());
        }

        return false;
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(token).getBody().getSubject();
    }
}
