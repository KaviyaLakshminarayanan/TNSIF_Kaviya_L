package inheritance.java;

public class Dog extends Animal{
	public Dog(String name) {
        super(name); // Call the constructor of the superclass
    }

    // Method overriding
    @Override
    public void eat() {
        System.out.println(name + " is eating dog food.");
    }

    // New method specific to Dog
    public void bark() {
        System.out.println(name + " is barking.");
    }
}
