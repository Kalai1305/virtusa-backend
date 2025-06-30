package com.example.inventory.controller;

import com.example.inventory.model.InventoryItem;
import com.example.inventory.service.InventoryItemService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin(origins = "http://localhost:5173")
public class InventoryItemController {

    private final InventoryItemService service;

    public InventoryItemController(InventoryItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<InventoryItem> getAll() {
        return service.getAllItems();
    }

    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody InventoryItem item) {
        try {
            InventoryItem savedItem = service.saveItem(item); // ✅ Internally handles batch + sku + name check
            return ResponseEntity.ok(savedItem);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("SKU already exists");
        }
    }

    @PostMapping("/bulk")
    public List<InventoryItem> bulkUpload(@RequestBody List<InventoryItem> items) {
        return service.saveAll(items); // ✅ Internally handles uniqueness with batch check
    }

    @PutMapping("/{id}")
    public InventoryItem updateItem(@PathVariable Long id, @RequestBody InventoryItem updatedItem) {
        return service.updateItem(id, updatedItem);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
    }
}