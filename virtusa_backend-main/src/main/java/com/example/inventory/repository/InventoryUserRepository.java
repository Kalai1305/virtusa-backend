package com.example.inventory.repository;

import com.example.inventory.model.InventoryUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryUserRepository extends JpaRepository<InventoryUser, String> {
    InventoryUser findByUsername(String username);
}
