package com.tns.fooddeliverysystem.services;

import com.tns.fooddeliverysystem.entities.Order;

public class DiscountService {

    // Apply coupon or threshold discount: returns final amount
    public double applyDiscount(double total, String coupon) {
        double finalAmount = total;
        if (coupon != null && coupon.equalsIgnoreCase("WELCOME10")) {
            finalAmount = total * 0.90;
            System.out.println("Coupon WELCOME10 applied (10% off). Saved: ₹" + (total - finalAmount));
        } else if (total >= 500) {
            finalAmount = total * 0.95;
            System.out.println("Auto discount for orders >= ₹500 applied (5% off). Saved: ₹" + (total - finalAmount));
        } else {
            System.out.println("No discount applied.");
        }
        return finalAmount;
    }
}
