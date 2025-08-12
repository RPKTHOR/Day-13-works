package com.example.restaurantservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurantservice.entity.MenuItem;
import com.example.restaurantservice.repository.MenuItemRepository;

@Service
public class MenuItemService {
    @Autowired private MenuItemRepository menuRepo;
    public MenuItem addItem(MenuItem item) { return menuRepo.save(item); }
    public List<MenuItem> getItemsByRestaurant(Long restaurantId) {
        return menuRepo.findByRestaurantId(restaurantId);
    }
}
