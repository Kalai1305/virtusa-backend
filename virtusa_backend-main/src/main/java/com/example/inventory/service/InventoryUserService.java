package com.example.inventory.service;

import com.example.inventory.model.InventoryUser;
import com.example.inventory.repository.InventoryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryUserService {

    @Autowired
    private InventoryUserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<InventoryUser> getAllUsers() {
        return repo.findAll();
    }

    public InventoryUser createUser(InventoryUser user) {
        if (repo.existsById(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public void deleteUser(String username) {
        repo.deleteById(username);
    }

    public boolean login(String username, String password) {
        InventoryUser user = repo.findByUsername(username);
        return user != null && passwordEncoder.matches(password, user.getPassword());
    }

    // ✅ NEW: Reset user password to a custom one from admin
    public boolean resetPassword(String username, String newPassword) {
        InventoryUser user = repo.findByUsername(username);
        if (user != null) {
            user.setPassword(passwordEncoder.encode(newPassword)); // 🔒 Securely encoded
            repo.save(user);
            return true;
        }
        return false;
    }
}