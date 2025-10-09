package nonAccessSpecifier.java;

public  final class SavingsAccount extends BankAccount {
	private static int accountCounter = 0;

    public SavingsAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
        accountCounter++; // increment whenever a new account is created
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited.");
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= Constants.MIN_BALANCE) {
            balance -= amount;
            System.out.println(amount + " withdrawn.");
        } else {
            System.out.println("Cannot withdraw. Minimum balance requirement: " + Constants.MIN_BALANCE);
        }
    }

    // static method to get number of accounts
    public static int getAccountCount() {
        return accountCounter;
    }
}
