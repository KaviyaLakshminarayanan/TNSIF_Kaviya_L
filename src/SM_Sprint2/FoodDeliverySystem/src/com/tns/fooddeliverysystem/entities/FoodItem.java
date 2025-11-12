package com.tns.fooddeliverysystem.entities;

import java.util.Objects;

public class FoodItem {
    private int id;
    private String name;
    private double price;
    private String cuisine; // used by recommender

    public FoodItem(int id, String name, double price, String cuisine) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.cuisine = cuisine;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCuisine() { return cuisine; }

    @Override
    public String toString() {
        return String.format("FoodItem{id=%d, name='%s', price=₹%.2f, cuisine='%s'}", id, name, price, cuisine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoodItem)) return false;
        FoodItem foodItem = (FoodItem) o;
        return id == foodItem.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

