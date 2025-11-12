package com.tns.fooddeliverysystem.services;

import com.tns.fooddeliverysystem.entities.*;

import java.util.*;
import java.util.stream.Collectors;

public class RecommendationService {

    // Simple frequency-based recommender (cuisine-level)
    public List<FoodItem> recommend(Customer customer, List<Restaurant> restaurants) {
        if (customer.getOrderHistory().isEmpty()) {
            // cold start: top priced items
            return restaurants.stream().flatMap(r -> r.getMenu().stream())
                    .sorted(Comparator.comparingDouble(FoodItem::getPrice).reversed())
                    .limit(5)
                    .collect(Collectors.toList());
        }

        Map<String, Long> cuisineCount = customer.getOrderHistory().stream()
                .flatMap(o -> o.getItems().keySet().stream())
                .collect(Collectors.groupingBy(FoodItem::getCuisine, Collectors.counting()));

        String topCuisine = cuisineCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");

        List<FoodItem> recs = new ArrayList<>();
        for (Restaurant r : restaurants) {
            for (FoodItem f : r.getMenu()) {
                if (f.getCuisine().equalsIgnoreCase(topCuisine) || topCuisine.isEmpty()) {
                    recs.add(f);
                }
            }
        }
        return recs.stream().limit(5).collect(Collectors.toList());
    }

    public void showRecommendations(Customer c, List<Restaurant> restaurants) {
        List<FoodItem> recs = recommend(c, restaurants);
        System.out.println("\nRecommendations for " + c.getUsername() + ":");
        if (recs.isEmpty()) System.out.println("  Try something new today!");
        else recs.forEach(fi -> System.out.println("  -> " + fi));
    }
}
