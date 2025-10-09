package polymorphism.java;

public class Polymorphism {
	public static void main(String[] args) {
        // Polymorphic references
        Shape s1 = new Circle(5);
        Shape s2 = new Rectangle(4, 6);
        Shape s3 = new Triangle(3, 8);

        // Each call uses the overridden version (runtime polymorphism)
        s1.draw();
        System.out.println("Area: " + s1.area());

        s2.draw();
        System.out.println("Area: " + s2.area());

        s3.draw();
        System.out.println("Area: " + s3.area());

        // Example of polymorphic array
        System.out.println("\nUsing array of shapes:");
        Shape[] shapes = {s1, s2, s3};
        for (Shape shape : shapes) {
            shape.draw();
            System.out.println("Area: " + shape.area());
        }
    }
}
