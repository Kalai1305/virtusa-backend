package com.example.inventory.repository;

import com.example.inventory.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

    @Query("SELECT i FROM InventoryItem i WHERE LOWER(i.itemName) = LOWER(:itemName) AND LOWER(i.category) = LOWER(:category)")
    Optional<InventoryItem> findByItemNameAndCategoryIgnoreCase(@Param("itemName") String itemName, @Param("category") String category);

    @Query("SELECT i FROM InventoryItem i WHERE LOWER(i.itemName) = LOWER(:itemName) AND LOWER(i.sku) = LOWER(:sku) AND LOWER(i.batch) = LOWER(:batch)")
    Optional<InventoryItem> findByNameSkuAndBatchIgnoreCase(@Param("itemName") String itemName, @Param("sku") String sku, @Param("batch") String batch);
}