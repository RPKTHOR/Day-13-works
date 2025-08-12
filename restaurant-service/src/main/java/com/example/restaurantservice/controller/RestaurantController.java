package com.example.restaurantservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.restaurantservice.entity.Restaurant;
import com.example.restaurantservice.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired private RestaurantService service;

    @PostMapping public ResponseEntity<Restaurant> add(@RequestBody Restaurant r) {
        return ResponseEntity.ok(service.addRestaurant(r));
    }

    @GetMapping public List<Restaurant> getAll() { return service.getAll(); }

    @GetMapping("/{id}") public Restaurant getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
