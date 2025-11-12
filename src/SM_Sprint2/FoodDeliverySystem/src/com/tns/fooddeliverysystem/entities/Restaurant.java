package com.tns.fooddeliverysystem.entities;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int id;
    private String name;
    private String location;
    private List<FoodItem> menu = new ArrayList<>();

    public Restaurant(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public List<FoodItem> getMenu() { return menu; }

    public void addFoodItem(FoodItem fi) { menu.add(fi); }
    public void removeFoodItemById(int foodId) { menu.removeIf(f -> f.getId() == foodId); }

    public FoodItem findFoodById(int foodId) {
        return menu.stream().filter(f -> f.getId() == foodId).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Restaurant{id=%d,name='%s',location='%s'}%n", id, name, location));
        for (FoodItem f : menu) sb.append("  ").append(f).append("\n");
        return sb.toString();
    }
}
