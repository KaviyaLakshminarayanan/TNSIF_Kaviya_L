package polymorphism.java;

public class Circle extends Shape {
	 private double radius;

	    public Circle(double radius) {
	        this.radius = radius;
	    }

	    @Override
	    public void draw() {
	        System.out.println("Drawing a circle");
	    }

	    @Override
	    public double area() {
	        return Math.PI * radius * radius;
	    }
}
