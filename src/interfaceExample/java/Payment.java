package interfaceExample.java;

public interface Payment {
	void pay(double amount);

    // Default method (optional implementation)
    default void paymentMode() {
        System.out.println("Processing payment...");
    }
}
