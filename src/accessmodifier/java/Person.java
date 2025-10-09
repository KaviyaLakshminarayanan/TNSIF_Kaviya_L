package accessmodifier.java;

public class Person {
	 private String name;

	    // Default (no modifier) variable - accessible within the same package
	    int age;

	    // Protected variable - accessible within package and by subclasses
	    protected String address;

	    // Public variable - accessible everywhere
	    public String country = "India";

	    // Constructor
	    public Person(String name, int age, String address) {
	        this.name = name;
	        this.age = age;
	        this.address = address;
	    }

	    // Public method - accessible from anywhere
	    public void displayInfo() {
	        System.out.println("Name: " + name);     // private, accessed inside class
	        System.out.println("Age: " + age);       // default
	        System.out.println("Address: " + address); // protected
	        System.out.println("Country: " + country); // public
	    }

	    // Private method - accessible only within this class
	    private void showSecret() {
	        System.out.println("This is a private method.");
	    }

	    // Public method that can call the private one
	    public void revealSecret() {
	        showSecret();
	    }
}
