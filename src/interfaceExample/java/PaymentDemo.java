package interfaceExample.java;

public class PaymentDemo {
	 public static void main(String[] args) {
	        Payment credit = new CreditCardPayment();
	        Payment paypal = new PayPalPayment();

	        credit.paymentMode(); // Default method from interface
	        credit.pay(500);

	        paypal.paymentMode();
	        paypal.pay(1200);
	    }
}
