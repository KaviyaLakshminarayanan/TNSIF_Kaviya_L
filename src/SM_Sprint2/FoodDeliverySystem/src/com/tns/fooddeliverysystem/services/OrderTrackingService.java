package com.tns.fooddeliverysystem.services;

import com.tns.fooddeliverysystem.entities.Order;

public class OrderTrackingService {

    // Simulate stage updates (blocking, small waits for demo)
    public void trackOrder(Order order) {
        if (order == null) {
            System.out.println("No such order to track.");
            return;
        }
        String[] stages = {"Preparing", "OutForDelivery", "Delivered"};
        for (String s : stages) {
            try {
                Thread.sleep(600); // 0.6s pause - demo only
            } catch (InterruptedException ignored) {}
            order.setStatus(s);
            System.out.println("Order " + order.getOrderId() + " status: " + order.getStatus());
        }
    }
}
