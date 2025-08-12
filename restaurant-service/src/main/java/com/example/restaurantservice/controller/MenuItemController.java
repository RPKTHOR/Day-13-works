package com.example.restaurantservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.restaurantservice.entity.MenuItem;
import com.example.restaurantservice.service.MenuItemService;

@RestController
@RequestMapping("/restaurants/{id}/menu-items")
public class MenuItemController {
    @Autowired private MenuItemService service;

    @PostMapping public ResponseEntity<MenuItem> add(@PathVariable Long id, @RequestBody MenuItem item) {
        item.setRestaurantId(id);
        return ResponseEntity.ok(service.addItem(item));
    }

    @GetMapping public List<MenuItem> getItems(@PathVariable Long id) {
        return service.getItemsByRestaurant(id);
    }
}

