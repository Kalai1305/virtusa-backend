package com.example.inventory.repository;

import com.example.inventory.model.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository extends JpaRepository<AdminUser, String> {
    AdminUser findByUsernameAndPassword(String username, String password);
}
