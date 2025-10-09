package nonAccessSpecifier.java;

public abstract class BankAccount {
	 protected String accountHolder;
	    protected double balance;

	    public BankAccount(String accountHolder, double balance) {
	        this.accountHolder = accountHolder;
	        this.balance = balance;
	    }

	    // abstract method – must be implemented in subclass
	    public abstract void deposit(double amount);

	    // abstract method
	    public abstract void withdraw(double amount);

	    // regular method
	    public void showBalance() {
	        System.out.println(accountHolder + "'s Balance: " + balance);
	    }
}
