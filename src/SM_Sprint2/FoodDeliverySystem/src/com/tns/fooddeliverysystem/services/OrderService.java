package com.tns.fooddeliverysystem.services;

import com.tns.fooddeliverysystem.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderService {
    private List<Order> orders = new ArrayList<>();
    private List<DeliveryPerson> deliveryPeople = new ArrayList<>();

    public void addDeliveryPerson(DeliveryPerson dp) { deliveryPeople.add(dp); }

    public DeliveryPerson findDeliveryPersonById(int id) {
        Optional<DeliveryPerson> d = deliveryPeople.stream().filter(x -> x.getDeliveryPersonId() == id).findFirst();
        return d.orElse(null);
    }

    public Order placeOrder(Customer customer, Restaurant restaurant, java.util.Map<FoodItem,Integer> itemsInCart, double finalAmount, String deliveryAddress) {
        Order o = new Order(customer, itemsInCart, deliveryAddress);
        // set ETA naive
        int eta = 10 + itemsInCart.size() * 3;
        o.setEtaMinutes(eta);
        orders.add(o);
        customer.addOrderToHistory(o);
        System.out.println("Order placed: " + o);
        return o;
    }

    public Order findOrderById(int id) {
        return orders.stream().filter(o -> o.getOrderId() == id).findFirst().orElse(null);
    }

    public void viewOrders() {
        if (orders.isEmpty()) System.out.println("No orders yet.");
        else orders.forEach(System.out::println);
    }

    public List<Order> getOrders() { return orders; }
}

