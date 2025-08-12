package com.example.restaurantservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurantservice.entity.MenuItem;
import com.example.restaurantservice.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<MenuItem> findByRestaurantId(Long restaurantId);
}