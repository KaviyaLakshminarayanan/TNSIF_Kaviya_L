package exceptionhandling.java;

public class Exception {
	 public static void main(String[] args) {
	        Calculator calc = new Calculator();

	        // Example 1: Handling ArithmeticException
	        try {
	            int result = calc.divide(10, 0);
	            System.out.println("Result: " + result);
	        } catch (ArithmeticException e) {
	            System.out.println("Caught exception: " + e.getMessage());
	        } finally {
	            System.out.println("Finally block executed for division.");
	        }

	        System.out.println();

	        // Example 2: Handling NumberFormatException
	        try {
	            int number = calc.parseNumber("abc");
	            System.out.println("Parsed number: " + number);
	        } catch (NumberFormatException e) {
	            System.out.println("Caught exception: " + e.getMessage());
	        } finally {
	            System.out.println("Finally block executed for parsing.");
	        }

	        System.out.println();

	        // Example 3: Multiple exceptions
	        try {
	            int[] arr = {1, 2, 3};
	            System.out.println(arr[5]); // ArrayIndexOutOfBoundsException
	        } catch (ArithmeticException e) {
	            System.out.println("Arithmetic Exception caught.");
	        } catch (ArrayIndexOutOfBoundsException e) {
	            System.out.println("Array Index Out Of Bounds Exception caught: " + e.getMessage());
	        } finally {
	            System.out.println("Finally block executed for array.");
	        }
	    }
}
