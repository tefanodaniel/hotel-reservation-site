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
import java.io.FileNotFoundException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    ImageRepository imageRepository;
    
    public ResourceController(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }
    
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
    
    @GetMapping("hotel/{id}/images")
    public ResponseEntity<String> getHotelImageList(@PathVariable Long id) {
        
        List<String> image_ids = new ArrayList<>();
        for (Image im : imageRepository.findByHotelId(id))
        {
            image_ids.add(im.photos_id.toString());
        }
        
        String res = !image_ids.isEmpty() ? String.join("&", image_ids) : "";
        
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    

    @GetMapping("image/hotel-{id}")
    public ResponseEntity<byte[]> getHotelImage(@PathVariable Long id) throws IOException {
        
        // Load the image from the resources folder
        Resource image;
        try 
        {
            String path;
            if (id > 7) path = "apple_abstract-wallpaper-5120x2880.jpg";
            else path = "angular_hotels/04-disney/disney-1.jpg";
            
            image = new ClassPathResource("static/" + path);
            if (image == null) {
                throw new FileNotFoundException(); // to make the compiler stop yelling at us
            }
            
        } catch (FileNotFoundException fileException) {
            return new ResponseEntity(HttpStatus.NOT_FOUND); // TODO: What does the client do with this?
        }

        // Convert the image to a byte array
        byte[] imageBytes = Files.readAllBytes(image.getFile().toPath());

        // Set headers for the response
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "image/jpeg");

        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

}