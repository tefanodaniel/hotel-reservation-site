/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.tefanodaniel.hotel_reservation_site_sb;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author stefa
 */
@Entity
@Table(name="user")
class User {
    
    @Id
    private Long user_id;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
    
    @Column(name = "display_name")
    private String display_name;
    
    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "role")
    private String role;
    
    public User() {
    }

    public User(Long id, String username, String email, String password, String display_name, String phone_number, String role) {
        this.user_id = id;
        this.username = username;
        this.password = password;
        this.display_name = display_name;
        this.phone_number = phone_number;
        this.role = role;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }
    
    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
