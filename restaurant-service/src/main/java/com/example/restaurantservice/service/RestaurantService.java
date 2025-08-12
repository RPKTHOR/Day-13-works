package com.example.restaurantservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurantservice.entity.Restaurant;
import com.example.restaurantservice.repository.RestaurantRepository;

@Service
public class RestaurantService {
    @Autowired private RestaurantRepository restaurantRepo;
    public Restaurant addRestaurant(Restaurant r) { return restaurantRepo.save(r); }
    public List<Restaurant> getAll() { return restaurantRepo.findAll(); }
    public Restaurant getById(Long id) { return restaurantRepo.findById(id).orElseThrow(); }
}