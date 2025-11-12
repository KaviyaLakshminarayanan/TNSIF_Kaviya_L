package com.tns.fooddeliverysystem.application;

import com.tns.fooddeliverysystem.entities.*;
import com.tns.fooddeliverysystem.services.*;

import java.util.Map;
import java.util.Scanner;

public class FoodDeliverySystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // services
        FoodService foodService = new FoodService();
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService();
        RecommendationService recommendationService = new RecommendationService();
        OrderTrackingService trackingService = new OrderTrackingService();
        DiscountService discountService = new DiscountService();

        // sample restaurant and delivery person list (interactive admin can add more)
        Restaurant r1 = new Restaurant(101, "HariOmDhaba", "MG Road");
        r1.addFoodItem(new FoodItem(1, "PanjabiThali", 340, "North Indian"));
        r1.addFoodItem(new FoodItem(2, "PavBhaji", 140, "Street Food"));
        foodService.addRestaurant(r1);

        Restaurant r2 = new Restaurant(102, "ExpressInn", "Main St");
        r2.addFoodItem(new FoodItem(3, "Margherita Pizza", 280, "Italian"));
        r2.addFoodItem(new FoodItem(4, "Veg Pasta", 220, "Italian"));
        foodService.addRestaurant(r2);

        orderService.addDeliveryPerson(new DeliveryPerson(1, "Manoj", 7087990078L));
        orderService.addDeliveryPerson(new DeliveryPerson(2, "Priya", 9876543210L));

        System.out.println("=== Smart Food Delivery System ===");

        mainLoop:
        while (true) {
            System.out.println("\n1. Admin Menu\n2. Customer Menu\n3. Exit");
            System.out.print("Choose an option: ");
            String s = sc.nextLine().trim();
            switch (s) {
                case "1":
                    adminMenu(sc, foodService, orderService);
                    break;
                case "2":
                    customerMenu(sc, foodService, customerService, orderService, recommendationService, trackingService, discountService);
                    break;
                case "3":
                    System.out.println("Saving and exiting... (no persistence in this demo)");
                    break mainLoop;
                default:
                    System.out.println("Invalid input.");
            }
        }

        sc.close();
    }

    private static void adminMenu(Scanner sc, FoodService foodService, OrderService orderService) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Restaurant");
            System.out.println("2. Add Food Item to Restaurant");
            System.out.println("3. Remove Food Item from Restaurant");
            System.out.println("4. View Restaurants and Menus");
            System.out.println("5. View Orders");
            System.out.println("6. Add Delivery Person");
            System.out.println("7. Assign Delivery Person to Order");
            System.out.println("8. Back");
            System.out.print("Choose: ");
            String opt = sc.nextLine().trim();
            switch (opt) {
                case "1":
                    System.out.print("Enter Restaurant ID: "); int rid = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Restaurant Name: "); String rname = sc.nextLine();
                    System.out.print("Enter Location: "); String loc = sc.nextLine();
                    foodService.addRestaurant(new Restaurant(rid, rname, loc));
                    System.out.println("Restaurant added.");
                    break;
                case "2":
                    System.out.print("Enter Restaurant ID: "); int rrid = Integer.parseInt(sc.nextLine());
                    Restaurant rest = foodService.findRestaurantById(rrid);
                    if (rest == null) { System.out.println("Restaurant not found."); break; }
                    System.out.print("Food ID: "); int fid = Integer.parseInt(sc.nextLine());
                    System.out.print("Food name: "); String fname = sc.nextLine();
                    System.out.print("Price: "); double fprice = Double.parseDouble(sc.nextLine());
                    System.out.print("Cuisine: "); String cuisine = sc.nextLine();
                    rest.addFoodItem(new FoodItem(fid, fname, fprice, cuisine));
                    System.out.println("Food item added.");
                    break;
                case "3":
                    System.out.print("Enter Restaurant ID: "); int rrm = Integer.parseInt(sc.nextLine());
                    Restaurant rfound = foodService.findRestaurantById(rrm);
                    if (rfound == null) { System.out.println("Not found"); break; }
                    System.out.print("Enter Food ID to remove: "); int remId = Integer.parseInt(sc.nextLine());
                    rfound.removeFoodItemById(remId);
                    System.out.println("Removed if existed.");
                    break;
                case "4":
                    foodService.viewRestaurantsAndMenus();
                    break;
                case "5":
                    orderService.viewOrders();
                    break;
                case "6":
                    System.out.print("Delivery Person ID: "); int dpId = Integer.parseInt(sc.nextLine());
                    System.out.print("Name: "); String dpName = sc.nextLine();
                    System.out.print("Contact No: "); long dpContact = Long.parseLong(sc.nextLine());
                    orderService.addDeliveryPerson(new DeliveryPerson(dpId, dpName, dpContact));
                    System.out.println("Delivery person added.");
                    break;
                case "7":
                    System.out.print("Order ID: "); int oid = Integer.parseInt(sc.nextLine());
                    System.out.print("Delivery Person ID: "); int did = Integer.parseInt(sc.nextLine());
                    Order ord = orderService.findOrderById(oid);
                    DeliveryPerson dp = orderService.findDeliveryPersonById(did);
                    if (ord == null || dp == null) { System.out.println("Order or DP not found."); break; }
                    ord.setDeliveryPerson(dp);
                    ord.setStatus("OutForDelivery");
                    System.out.println("Assigned DP to order.");
                    break;
                case "8":
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void customerMenu(Scanner sc, FoodService foodService, CustomerService customerService, OrderService orderService,
                                     RecommendationService recommendationService, OrderTrackingService trackingService, DiscountService discountService) {
        System.out.print("Enter Customer ID (or 0 to create new): ");
        int custId = Integer.parseInt(sc.nextLine());
        Customer customer;
        if (custId == 0) {
            System.out.print("Enter new Customer ID: "); int nid = Integer.parseInt(sc.nextLine());
            System.out.print("Enter name: "); String nm = sc.nextLine();
            System.out.print("Enter contact no: "); long cn = Long.parseLong(sc.nextLine());
            customer = new Customer(nid, nm, cn);
            customerService.addCustomer(customer);
        } else {
            customer = customerService.findCustomerById(custId);
            if (customer == null) {
                System.out.println("Customer not found, creating new.");
                System.out.print("Enter name: "); String nm = sc.nextLine();
                System.out.print("Enter contact no: "); long cn = Long.parseLong(sc.nextLine());
                customer = new Customer(custId, nm, cn);
                customerService.addCustomer(customer);
            } else {
                System.out.println("Welcome back, " + customer.getUsername());
            }
        }

        // customer loop
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. View Restaurants & Menus");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Place Order");
            System.out.println("5. View Orders");
            System.out.println("6. View Recommendations");
            System.out.println("7. Set Diet Preference");
            System.out.println("8. Back");
            System.out.print("Choose: ");
            String opt = sc.nextLine().trim();
            switch (opt) {
                case "1":
                    foodService.viewRestaurantsAndMenus();
                    break;
                case "2":
                    System.out.print("Enter Restaurant ID: "); int rid = Integer.parseInt(sc.nextLine());
                    Restaurant rest = foodService.findRestaurantById(rid);
                    if (rest == null) { System.out.println("Restaurant not found."); break; }
                    System.out.print("Enter Food ID: "); int fid = Integer.parseInt(sc.nextLine());
                    FoodItem fi = rest.findFoodById(fid);
                    if (fi == null) { System.out.println("Food not found."); break; }
                    System.out.print("Quantity: "); int qty = Integer.parseInt(sc.nextLine());
                    customer.getCart().addItem(fi, qty);
                    System.out.println("Added to cart.");
                    break;
                case "3":
                    System.out.println(customer.getCart());
                    break;
                case "4":
                    if (customer.getCart().isEmpty()) { System.out.println("Cart empty."); break; }
                    double total = customer.getCart().calculateTotal();
                    System.out.printf("Cart total: ₹%.2f%n", total);
                    System.out.print("Enter coupon code or press Enter: ");
                    String coupon = sc.nextLine().trim();
                    if (coupon.isEmpty()) coupon = null;
                    double finalAmount = discountService.applyDiscount(total, coupon);
                    System.out.print("Enter delivery address: ");
                    String addr = sc.nextLine();
                    Order o = orderService.placeOrder(customer, null, customer.getCart().getItems(), finalAmount, addr);
                    // assign a dp automatically (simple round-robin)
                    if (!orderService.getOrders().isEmpty()) {
                        orderService.getOrders(); // no-op
                    }
                    trackingService.trackOrder(o);
                    customer.getCart().clear();
                    break;
                case "5":
                    customer.getOrderHistory().forEach(System.out::println);
                    break;
                case "6":
                    recommendationService.showRecommendations(customer, foodService.getRestaurants());
                    break;
                case "7":
                    System.out.print("Enter diet preference (vegetarian/low-carb/none): ");
                    String pref = sc.nextLine();
                    customer.setDietPreference(pref);
                    System.out.println("Saved.");
                    break;
                case "8":
                    return;
                default:
                    System.out.println("Invalid.");
            }
        }
    }
}
