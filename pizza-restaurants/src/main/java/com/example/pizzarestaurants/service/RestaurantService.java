package com.example.pizzarestaurants.service;


import com.example.pizzarestaurants.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RestaurantService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Restaurant> getNearestRestaurants(double userLatitude, double userLongitude) {
        String query = "SELECT id, name, latitude, longitude, " +
                "earth_distance(ll_to_earth(?, ?), ll_to_earth(latitude, longitude)) as distance " +
                "FROM restaurant " +
                "ORDER BY distance " +
                "LIMIT 5";

        return jdbcTemplate.query(query, new Object[]{userLatitude, userLongitude},
                new BeanPropertyRowMapper<>(Restaurant.class));
    }


}
