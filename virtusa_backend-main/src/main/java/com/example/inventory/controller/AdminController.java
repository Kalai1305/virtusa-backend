package com.example.inventory.controller;

import com.example.inventory.model.InventoryUser;
import com.example.inventory.service.InventoryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/admin/inventory-users")
public class AdminController {

    @Autowired
    private InventoryUserService service;

    @GetMapping
    public List<InventoryUser> getAllUsers() {
        return service.getAllUsers();
    }

    @PostMapping
    public InventoryUser createUser(@RequestBody InventoryUser user) {
        return service.createUser(user);
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {
        service.deleteUser(username);
    }

    // ✅ NEW: Reset password to a custom value from admin
    @PutMapping("/{username}/reset")
    public ResponseEntity<String> resetPassword(
            @PathVariable String username,
            @RequestBody Map<String, String> requestBody
    ) {
        String newPassword = requestBody.get("password");
        boolean success = service.resetPassword(username, newPassword);

        if (success) {
            return ResponseEntity.ok("Password updated for user: " + username);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}