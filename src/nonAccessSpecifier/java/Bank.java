package nonAccessSpecifier.java;

public class Bank {
	public static void main(String[] args) {
        // Call static method directly
        Constants.printBankName();

        // Create accounts
        SavingsAccount acc1 = new SavingsAccount("Alice", 1000);
        SavingsAccount acc2 = new SavingsAccount("Bob", 1500);

        // Deposit and withdraw
        acc1.deposit(500);
        acc1.withdraw(800);
        acc1.showBalance();

        acc2.withdraw(1200);
        acc2.showBalance();

        // Static variable shows shared info
        System.out.println("Total accounts created: " + SavingsAccount.getAccountCount());

        // Access final variable
        System.out.println("Minimum balance: " + Constants.MIN_BALANCE);
    }
}
