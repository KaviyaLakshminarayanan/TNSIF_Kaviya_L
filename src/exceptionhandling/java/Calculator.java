package exceptionhandling.java;

public class Calculator {
	public int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed!");
        }
        return a / b;
    }

    // Method to parse string to integer
    public int parseNumber(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }
}
