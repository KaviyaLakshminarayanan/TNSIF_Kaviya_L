package com.tns.fooddeliverysystem.entities;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    // Map FoodItem -> quantity
    private Map<FoodItem, Integer> items = new LinkedHashMap<>();

    public void addItem(FoodItem fi, int quantity) {
        if (fi == null || quantity <= 0) return;
        items.put(fi, items.getOrDefault(fi, 0) + quantity);
    }

    public void removeItem(FoodItem fi) {
        items.remove(fi);
    }

    public Map<FoodItem, Integer> getItems() {
        return items;
    }

    public double calculateTotal() {
        return items.entrySet().stream()
                .mapToDouble(e -> e.getKey().getPrice() * e.getValue())
                .sum();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }

    @Override
    public String toString() {
        if (items.isEmpty()) return "Cart is empty.";
        StringBuilder sb = new StringBuilder();
        items.forEach((f, q) -> sb.append(String.format("- %s x%d : ₹%.2f%n", f.getName(), q, f.getPrice() * q)));
        sb.append(String.format("Total: ₹%.2f", calculateTotal()));
        return sb.toString();
    }
}
