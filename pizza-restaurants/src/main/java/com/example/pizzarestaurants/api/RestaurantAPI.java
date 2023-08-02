package com.example.pizzarestaurants.api;

import com.example.pizzarestaurants.entity.Restaurant;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Configuration
@EnableScheduling
@CrossOrigin(origins = "*")
@RequestMapping("/api/restaurants")
public interface RestaurantAPI {

    @GetMapping()
    public ResponseEntity<List<Restaurant>> getNearestRestaurants(@RequestParam double latitude,
                                                                 @RequestParam double longitude);
}
