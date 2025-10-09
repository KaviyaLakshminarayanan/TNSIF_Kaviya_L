package wrapper.java;

public class Wrapper {
	public static void main(String[] args) {
        // Primitive types
        int num = 100;
        double price = 99.99;

        // Boxing – converting primitive to wrapper object
        Integer numObj = Integer.valueOf(num);
        Double priceObj = Double.valueOf(price);

        // Unboxing – converting wrapper object back to primitive
        int num2 = numObj.intValue();
        double price2 = priceObj.doubleValue();

        System.out.println("Integer Object: " + numObj);
        System.out.println("Double Object: " + priceObj);
        System.out.println("Primitive int: " + num2);
        System.out.println("Primitive double: " + price2);

        // Autoboxing & Auto-unboxing (automatic conversion)
        Integer autoNum = num;    // int → Integer
        int autoNum2 = autoNum;   // Integer → int

        System.out.println("Autoboxed Integer: " + autoNum);
        System.out.println("Auto-unboxed int: " + autoNum2);

        // Useful methods
        System.out.println("Max of 10 and 20: " + Integer.max(10, 20));
        System.out.println("Min of 5.5 and 3.3: " + Double.min(5.5, 3.3));
        System.out.println("Parsing string to int: " + Integer.parseInt("123"));
    }
}
