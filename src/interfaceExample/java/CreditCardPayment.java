package interfaceExample.java;

public class CreditCardPayment implements Payment{
	 @Override
	    public void pay(double amount) {
	        System.out.println("Paid " + amount + " using Credit Card.");
	    }
}
