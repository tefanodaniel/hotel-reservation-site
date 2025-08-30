/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.tefanodaniel.hotel_reservation_site_sb;

/**
 *
 * @author stefa
 */
import java.io.File;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/resources")
public class ResourceController {
    
    private String getFileExtension(String filename) {
        if (filename == null) {
            return null;
        }
        int dotIndex = filename.lastIndexOf(".");
        if (dotIndex >= 0) {
            return filename.substring(dotIndex + 1);
        }
        return "";
    }

    @GetMapping("/images/hotel/{id}")
    public ResponseEntity<byte[]> getImage() throws IOException {
        // Load the image from the resources folder
        Resource image = new ClassPathResource("static/apple-abstract-wallpaper-5120x2880.jpg");

        // Convert the image to a byte array
        byte[] imageBytes = Files.readAllBytes(image.getFile().toPath());

        // Set headers for the response
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "image/jpeg");

        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }
   
}


