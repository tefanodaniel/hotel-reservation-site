/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.tefanodaniel.hotel_reservation_site_sb;

/**
 *
 * @author stefa
 */
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;

public class JwtGenerator {

    // A secret key for signing the token. In production, this should be stored securely.
    private static final String SECRET_KEY = "your-very-strong-secret-key"; 
    private static final String ISSUER = "hotel-reservation-siteSB";
    
    public static String generateToken(String username) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(username)
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis() + 3600000)) // Token expires in 1 hour
                    .sign(algorithm);
        } catch (Exception e) {
            // Handle exceptions like IllegalArgumentException or JWTCreationException
            System.err.println("Error generating JWT: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        String token = generateToken("example_user");
        if (token != null) {
            System.out.println("Generated JWT: " + token);
        }
    }
}

