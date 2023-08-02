package com.example.pizzarestaurants.controller;

import com.example.pizzarestaurants.api.RestaurantAPI;
import com.example.pizzarestaurants.entity.Restaurant;
import com.example.pizzarestaurants.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController implements RestaurantAPI {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public ResponseEntity<List<Restaurant>> getNearestRestaurants(double latitude, double longitude) {
        List<Restaurant> nearestFiveRestaurant = restaurantService.getNearestRestaurants(latitude, longitude);
        return new ResponseEntity<>(nearestFiveRestaurant, HttpStatus.OK);
    }
}
