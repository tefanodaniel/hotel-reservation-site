/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.tefanodaniel.hotel_reservation_site_sb;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author stefa
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    
    private final UserRepository userRepository;
    
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @PostMapping("/{username}{password}")
    public String loginGetAuthenticationToken(@PathVariable String username, @PathVariable String password) {
        
        // check if credentials in database
        var user = this.userRepository.findByUsername(username);
        if (user != null && password.equals(user.getPassword())) {
            // return access token valid for 24 hours
            return JwtGenerator.generateToken(username);
        }
        else {
            throw new RuntimeException("User not found");
        }
    }
}
