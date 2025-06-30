// src/main/java/com/example/inventory/service/AdminUserService.java
package com.example.inventory.service;

import com.example.inventory.model.AdminUser;
import com.example.inventory.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserService {

    @Autowired
    private AdminUserRepository repo;

    public boolean isValidLogin(String username, String password) {
        return repo.findByUsernameAndPassword(username, password) != null;
    }
}
