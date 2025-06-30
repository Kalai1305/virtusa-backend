package com.example.inventory.controller;

import com.example.inventory.service.InventoryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/inventory")
public class InventoryLoginController {

    @Autowired
    private InventoryUserService service;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        boolean success = service.login(request.getUsername(), request.getPassword());
        if (success) {
            return "Login successful";
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    public static class LoginRequest {
        private String username;
        private String password;

        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}
