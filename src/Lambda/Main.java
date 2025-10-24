package Lambda;
	public class Main {
	    public static void main(String[] args) {
	        // Using lambda expressions to define the behavior of operate()
	        MathOperation addition = (a, b) -> a + b;
	        MathOperation subtraction = (a, b) -> a - b;
	        MathOperation multiplication = (a, b) -> a * b;
	        MathOperation division = (a, b) -> b != 0 ? a / b : 0;

	        // Using the lambda functions
	        System.out.println("Addition: " + addition.operate(10, 5));
	        System.out.println("Subtraction: " + subtraction.operate(10, 5));
	        System.out.println("Multiplication: " + multiplication.operate(10, 5));
	        System.out.println("Division: " + division.operate(10, 5));
	    }
}
