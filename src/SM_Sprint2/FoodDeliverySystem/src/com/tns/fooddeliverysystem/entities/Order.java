package com.tns.fooddeliverysystem.entities;

import java.util.LinkedHashMap;
import java.util.Map;

public class Order {
    private static int counter = 0;
    private int orderId;
    private Customer customer;
    private Map<FoodItem,Integer> items; // snapshot
    private double total;
    private String status; // Pending, Preparing, OutForDelivery, Delivered
    private DeliveryPerson deliveryPerson;
    private String deliveryAddress;
    private int etaMinutes;

    public Order(Customer customer, Map<FoodItem,Integer> cartItems, String deliveryAddress) {
        this.orderId = ++counter;
        this.customer = customer;
        this.items = new LinkedHashMap<>(cartItems);
        this.total = items.entrySet().stream().mapToDouble(e -> e.getKey().getPrice() * e.getValue()).sum();
        this.status = "Pending";
        this.deliveryAddress = deliveryAddress;
        this.etaMinutes = 0;
    }

    public int getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
    public Map<FoodItem,Integer> getItems() { return items; }
    public double getTotal() { return total; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public DeliveryPerson getDeliveryPerson() { return deliveryPerson; }
    public void setDeliveryPerson(DeliveryPerson deliveryPerson) { this.deliveryPerson = deliveryPerson; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public void setEtaMinutes(int etaMinutes) { this.etaMinutes = etaMinutes; }
    public int getEtaMinutes() { return etaMinutes; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Order{id=%d, customer=%s, status=%s, total=₹%.2f}", orderId, customer.getUsername(), status, total));
        if (deliveryPerson != null) sb.append(", delivery=").append(deliveryPerson.getName());
        if (etaMinutes > 0) sb.append(", ETA=").append(etaMinutes).append(" mins");
        return sb.toString();
    }
}

