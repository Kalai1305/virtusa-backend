// src/main/java/com/example/inventory/controller/AdminLoginController.java
package com.example.inventory.controller;

import com.example.inventory.service.AdminUserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminLoginController {

    @Autowired
    private AdminUserService service;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        boolean success = service.isValidLogin(request.getUsername(), request.getPassword());
        if (success) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }

    @Setter
    @Getter
    public static class LoginRequest {
        private String username;
        private String password;

    }
}
