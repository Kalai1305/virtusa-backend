package com.example.inventory.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryUser {
    @Id
    private String username;

    private String password;
}
