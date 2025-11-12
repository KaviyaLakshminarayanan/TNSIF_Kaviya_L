package com.tns.fooddeliverysystem.entities;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private Cart cart;
    private List<Order> orderHistory;
    private String dietPreference; // optional, used by recommender
    private double walletBalance; // optional realistic feature

    public Customer(int userId, String username, long contactNo) {
        super(userId, username, contactNo);
        this.cart = new Cart();
        this.orderHistory = new ArrayList<>();
        this.dietPreference = "none";
        this.walletBalance = 1000.0; // default for demo
    }

    public Cart getCart() { return cart; }
    public List<Order> getOrderHistory() { return orderHistory; }
    public void addOrderToHistory(Order order) { orderHistory.add(order); }
    public String getDietPreference() { return dietPreference; }
    public void setDietPreference(String dietPreference) { this.dietPreference = dietPreference; }
    public double getWalletBalance() { return walletBalance; }
    public void setWalletBalance(double walletBalance) { this.walletBalance = walletBalance; }

    @Override
    public String toString() {
        return String.format("Customer{id=%d,name='%s',contact=%d,wallet=₹%.2f}",
                userId, username, contactNo, walletBalance);
    }
}
