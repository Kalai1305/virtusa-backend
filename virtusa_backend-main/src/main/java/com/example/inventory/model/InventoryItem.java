package com.example.inventory.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inventory_team")
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    private String sku;
    private String category;
    private String batch;
    private int quantity;

    @Column(name = "expiry_date")
    private String expiryDate;

    @Column(name = "is_perishable")
    private boolean isPerishable;

    @Column(name = "is_damaged")
    private int damaged;
}